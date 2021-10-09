package com.konradgroup.notificationcompose

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.konradgroup.notificationcompose.services.NotificationService
import com.konradgroup.notificationcompose.ui.home.HomeScreen
import com.konradgroup.notificationcompose.ui.notification.NotificationScreen
import com.konradgroup.notificationcompose.ui.theme.NotificationTheme
import com.konradgroup.notificationcompose.utils.needsNotificationsPermission
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val needsNotificationsPermissionFlow = lifecycle.eventsAsFlow()
        .filter { it == Lifecycle.Event.ON_START }
        .map { needsNotificationsPermission(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NotificationTheme {
                NavHost(navController = navController, startDestination = Route.HOME) {
                    composable(Route.HOME) {
                        val needsNotificationsPermission by needsNotificationsPermissionFlow.collectAsState(
                            true
                        )

                        HomeScreen(
                            needsPermission = needsNotificationsPermission,
                            onSettingsIntentClick = {
                                showNotificationPreferences()
                            },
                            onDismissClicked = {
                                navController.navigate(Route.NOTIFICATION)
                            }
                        )
                    }

                    composable(Route.NOTIFICATION) {
                        val notifications by remember(lifecycle) {
                            NotificationService
                                .notificationsFlow
                                .flowWithLifecycle(lifecycle)
                        }
                            .collectAsState(initial = emptyList())

                        NotificationScreen(notifications.map { it.text ?: "" } )
                    }
                }
            }
        }
    }

    private fun showNotificationPreferences() {
        startActivity(Intent(Settings.ACTION_NOTIFICATION_ASSISTANT_SETTINGS))
    }
}

object Route {
    const val HOME = "home"
    const val NOTIFICATION = "NOTIFICATION"
}

@ExperimentalCoroutinesApi
private fun Lifecycle.eventsAsFlow(): Flow<Lifecycle.Event> = callbackFlow {
    val observer = LifecycleEventObserver { _, event -> trySend(event) }
    addObserver(observer)

    awaitClose { removeObserver(observer) }
}
