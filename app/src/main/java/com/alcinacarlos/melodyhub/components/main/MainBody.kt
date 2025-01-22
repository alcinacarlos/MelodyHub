package com.alcinacarlos.melodyhub.components.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.exoplayer.ExoPlayer
import com.alcinacarlos.melodyhub.CancionesDB
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.components.music.AlbumList
import com.alcinacarlos.melodyhub.components.music.MusicHome
import com.alcinacarlos.melodyhub.components.music.MusicPlayer
import com.alcinacarlos.melodyhub.model.NavigationItem
import com.alcinacarlos.melodyhub.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainBody(loginViewModel: LoginViewModel, exoPlayer: ExoPlayer) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colorResource(R.color.black),
            ) {
                val navigationItems = listOf(
                    NavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Default.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    NavigationItem(
                        title = "Albums",
                        selectedIcon = Icons.Default.Album,
                        unselectedIcon = Icons.Outlined.Album
                    ),
                    NavigationItem(
                        title = "Perfil",
                        selectedIcon = Icons.Default.AccountCircle,
                        unselectedIcon = Icons.Outlined.AccountCircle
                    ),
                    NavigationItem(
                        title = "Sobre nosotros",
                        selectedIcon = Icons.Default.Info,
                        unselectedIcon = Icons.Outlined.Info
                    ),
                    NavigationItem(
                        title = "Ajustes",
                        selectedIcon = Icons.Default.Settings,
                        unselectedIcon = Icons.Outlined.Settings
                    )
                )
                Row(
                    modifier = Modifier
                        .width(230.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Menú",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.white)
                    )
                }

                HorizontalDivider(modifier = Modifier.width(235.dp), thickness = 1.dp)
                Spacer(modifier = Modifier.height(20.dp))
                navigationItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 3.dp)
                            .width(210.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = colorResource(R.color.naranja),
                            unselectedContainerColor = colorResource(R.color.naranja2),
                            selectedTextColor = colorResource(R.color.white),
                            unselectedTextColor = colorResource(R.color.black),
                            unselectedIconColor = colorResource(R.color.black),
                            selectedIconColor = colorResource(R.color.white)
                        )
                    )
                }

            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                MainTopAppBar {
                    coroutineScope.launch { drawerState.open() }
                }
            },
            bottomBar = {
                MainNavigationBar(
                    index = selectedItemIndex,
                    onItemChanged = { selectedItemIndex = it })
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackBarHostState,
                    snackbar = {
                        Snackbar(
                            snackbarData = it,
                        )
                    }
                )
            }
        ) {
            SelectedScreen(selectedItemIndex, loginViewModel, exoPlayer)
        }
    }
}

@Composable
fun SelectedScreen(seccionSeleccionada: Int, loginViewModel: LoginViewModel, exoPlayer: ExoPlayer) {
    val currentSongSelected = remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 80.dp)
            .background(colorResource(R.color.black)),
        contentAlignment = Alignment.Center
    ) {

        MusicPlayer(
            exoPlayer,
            CancionesDB.canciones,
            currentSongSelected.intValue
        ) { currentSongSelected.intValue = it }

        when (seccionSeleccionada) {
            0 -> {
                MusicHome { currentSongSelected.intValue = it }
            }

            1 -> {
                AlbumList(CancionesDB.albums)
            }

            2 -> {
                Perfil(loginViewModel)

            }

            3 -> {
                Column(
                    modifier = Modifier.padding(30.dp)
                ) {
                    Text(
                        text = "Sobre Nosotros",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.white)
                    )
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", color = colorResource(R.color.white))
                }
            }

            4 -> {
                Text(text = "Ajustes", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = colorResource(R.color.white))
            }
        }
    }
}




