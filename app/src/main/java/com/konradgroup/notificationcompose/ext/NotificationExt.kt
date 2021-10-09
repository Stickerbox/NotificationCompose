package com.konradgroup.notificationcompose.ext

import android.service.notification.StatusBarNotification
import com.konradgroup.notificationcompose.models.Notification
import android.app.Notification as AndroidAppNotification

internal fun StatusBarNotification.toNotification() = Notification(
    text = text,
    title = title,
    titleBig = titleBig,
    subText = subText
)

internal val StatusBarNotification.text: String?
    get() = notification.extras.getString(AndroidAppNotification.EXTRA_TEXT)

internal val StatusBarNotification.title: String?
    get() = notification.extras.getString(AndroidAppNotification.EXTRA_TITLE)

internal val StatusBarNotification.titleBig: String?
    get() = notification.extras.getString(AndroidAppNotification.EXTRA_TITLE_BIG)

internal val StatusBarNotification.subText: String?
    get() = notification.extras.getString(AndroidAppNotification.EXTRA_SUB_TEXT)
