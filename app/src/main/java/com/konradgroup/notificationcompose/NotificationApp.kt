package com.konradgroup.notificationcompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotificationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("NotificationApp", "Hello")
    }
}
