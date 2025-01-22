package com.alcinacarlos.melodyhub.components.initial


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

@Composable
fun PagerBody2(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black))
    ) {
        SkipButton(pagerState, coroutineScope)
        SavingCentered()
        BackButton(pagerState, coroutineScope)
        NextButton(pagerState, coroutineScope)
        PageIndicator(pagerState)
    }
}

@Composable
fun SavingCentered() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageInitial(R.drawable.pager2)
        SavingText()
    }
}

@Composable
fun SavingText() {
    Text(
        text = stringResource(R.string.motivation1),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = colorResource(R.color.white),
        modifier = Modifier.padding(top = 15.dp, start = 35.dp)
    )
}
