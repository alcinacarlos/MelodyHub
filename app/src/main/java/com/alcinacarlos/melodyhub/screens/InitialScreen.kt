package com.alcinacarlos.melodyhub.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.alcinacarlos.melodyhub.components.initial.*

@Composable
fun InitialScreen(navController: NavController){

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 4 }
    )
    val coroutineScope = rememberCoroutineScope()
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> PagerBody1(pagerState, coroutineScope)
            1 -> PagerBody2(pagerState, coroutineScope)
            2 -> PagerBody3(pagerState, coroutineScope)
            3 -> InitialBody(pagerState, coroutineScope, navController)
        }
    }
}