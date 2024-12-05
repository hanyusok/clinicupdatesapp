package com.example.clinicupdatesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
//import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.clinicupdatesapp.ClinicUpdatesApplication

class MainActivity : ComponentActivity() {

//    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val appContainer = (application as ClinicUpdatesApplication).container
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
             JetnewsApp(appContainer, widthSizeClass)
        }
    }
}
