package com.alcinacarlos.melodyhub.components.initial


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.components.NextButton
import com.alcinacarlos.melodyhub.components.PageIndicator
import com.alcinacarlos.melodyhub.components.SkipButton
import kotlinx.coroutines.CoroutineScope

@Composable
fun PagerBody1(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black))
    ) {
        SkipButton(pagerState, coroutineScope)
        ContentCentered()
        NextButton(pagerState, coroutineScope)
        PageIndicator(pagerState)
    }
}

@Composable
fun ContentCentered() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WelcomeText()
        ImagenLogo(R.drawable.logo2)
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = stringResource(R.string.motivation3),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = colorResource(R.color.white),
        textAlign = TextAlign.Center
    )
}
@Composable
fun ImagenLogo(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Background image",
        modifier = Modifier
            .width(600.dp)
            .height(150.dp)
            .padding(30.dp),
        contentScale = ContentScale.FillHeight
    )
}

