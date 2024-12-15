package com.alcinacarlos.melodyhub.components.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    openDrawer: () -> Unit
){
    TopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = openDrawer, modifier = Modifier.padding(horizontal = 20.dp)) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            titleContentColor = colorResource(R.color.white),
            containerColor = colorResource(R.color.naranja),
            navigationIconContentColor = colorResource(R.color.black)
        ),
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = colorResource(R.color.black)
                )
            }
        }
    )
}
