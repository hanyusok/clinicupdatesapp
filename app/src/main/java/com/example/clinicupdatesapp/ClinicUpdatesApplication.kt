package com.example.clinicupdatesapp

import android.app.Application
import com.example.clinicupdatesapp.data.AppContainer
import com.example.clinicupdatesapp.data.AppContainerImpl


class ClinicUpdatesApplication : Application() {
    companion object {
        const val JETNEWS_APP_URI = "https://developer.android.com/jetnews"
    }

    // AppContainer instance used by the rest of classes to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}
