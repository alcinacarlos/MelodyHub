package com.alcinacarlos.melodyhub

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.alcinacarlos.melodyhub.navigation.AppNavigation
import com.alcinacarlos.melodyhub.ui.theme.MelodyHubTheme

class MainActivity : ComponentActivity() {
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        player = ExoPlayer.Builder(this).build()

        setContent {
            MelodyHubTheme {
                AppNavigation(player)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
