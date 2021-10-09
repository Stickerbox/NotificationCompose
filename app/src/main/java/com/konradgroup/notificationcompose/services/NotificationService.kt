package com.konradgroup.notificationcompose.services

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.konradgroup.notificationcompose.ext.toNotification
import com.konradgroup.notificationcompose.models.Notification
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class NotificationService : NotificationListenerService() {

    private var isConnected = false

    override fun getActiveNotifications(): Array<StatusBarNotification> {
        Log.d("NotificationService", "Fetching active notifications")
        return super.getActiveNotifications()
    }

    override fun onListenerConnected() {
        isConnected = true
        _notificationsFlow.value = activeNotifications.map { it.toNotification() }
    }

    override fun onListenerDisconnected() {
        isConnected = false
        super.onListenerDisconnected()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        _notificationsFlow.value = activeNotifications.map { it.toNotification() }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        _notificationsFlow.value = activeNotifications.map { it.toNotification() }
    }

    companion object {
        private val _notificationsFlow = MutableStateFlow(emptyList<Notification>())
        val notificationsFlow: Flow<List<Notification>> = _notificationsFlow
    }
}
