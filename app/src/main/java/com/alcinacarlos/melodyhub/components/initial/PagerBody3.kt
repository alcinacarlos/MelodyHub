package com.alcinacarlos.melodyhub.components.initial


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.components.BackButton
import com.alcinacarlos.melodyhub.components.ImageInitial
import com.alcinacarlos.melodyhub.components.NextButton
import com.alcinacarlos.melodyhub.components.PageIndicator
import com.alcinacarlos.melodyhub.components.SkipButton
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerBody3(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black))
    ) {
        SkipButton(pagerState, coroutineScope)
        TrackingCentered()
        BackButton(pagerState, coroutineScope)
        NextButton(pagerState, coroutineScope)
        PageIndicator(pagerState)
    }
}

@Composable
fun TrackingCentered() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageInitial(R.drawable.pager3)
        TrackingText()
    }
}

@Composable
fun TrackingText() {
    Text(
        text = stringResource(R.string.motivation2),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = colorResource(R.color.white),
        modifier = Modifier.padding(top = 20.dp, start = 30.dp)
    )
}
