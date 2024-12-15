package com.alcinacarlos.melodyhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alcinacarlos.melodyhub.navigation.AppNavigation
import com.alcinacarlos.melodyhub.ui.theme.MelodyHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MelodyHubTheme {
                AppNavigation()
            }
        }
    }
}
