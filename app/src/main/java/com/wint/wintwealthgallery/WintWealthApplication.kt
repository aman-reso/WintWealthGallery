package com.wint.wintwealthgallery

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WintWealthApplication : Application() {
    companion object{
        var appContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}