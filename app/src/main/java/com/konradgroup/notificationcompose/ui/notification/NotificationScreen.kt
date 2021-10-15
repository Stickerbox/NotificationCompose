package com.konradgroup.notificationcompose.ui.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konradgroup.notificationcompose.ui.theme.NotificationTheme

@Composable
fun NotificationScreen(
    notifications: List<String>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar() },
    ) {
        if (notifications.isNotEmpty()) {
            NotificationsList(notifications = notifications)
        } else {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("😖", fontSize = 72.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Nothing yet...", style = MaterialTheme.typography.h1)
            }
        }
    }
}

@Composable
private fun NotificationsList(notifications: List<String>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(notifications.filter { it.isNotEmpty() }) { notification ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
            ) {
                Text(notification, Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
private fun TopAppBar() {
    TopAppBar {
        Text(
            text = "Notification Thing",
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.h3
        )
    }
}

//region @Preview
@Preview(showBackground = true)
@Composable
fun NotificationScreen_Preview() {
    NotificationTheme {
        NotificationScreen(
            listOf(
                "I had a dream last night",
                "Hey what's up",
                "Hiiii :)"
            )
        )
    }
}
//endregion
