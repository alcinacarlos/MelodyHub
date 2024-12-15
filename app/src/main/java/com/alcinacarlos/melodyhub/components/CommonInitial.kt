package com.alcinacarlos.melodyhub.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ImageInitial(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Background image",
        modifier = Modifier
            .width(500.dp)
            .padding(30.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun PageIndicator(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(pagerState.pageCount) { pageIndex ->
            val color = if (pageIndex == pagerState.currentPage) Color.White else Color.Gray
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SkipButton(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, end = 25.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        pagerState.animateScrollToPage(pagerState.pageCount - 1)
                    }
                }
            },
            colors = ButtonColors(
                containerColor = colorResource(R.color.naranja),
                contentColor = colorResource(R.color.white),
                disabledContainerColor = colorResource(R.color.naranja),
                disabledContentColor = colorResource(R.color.naranja)
            )
        ) {
            Text(text = "Saltar")
        }
    }
}

@Composable
fun NextButton(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 30.dp, bottom = 50.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        IconButton(
            modifier = Modifier.size(60.dp),
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            colors = IconButtonColors(
                containerColor = colorResource(R.color.naranja),
                contentColor = colorResource(R.color.white),
                disabledContainerColor = colorResource(R.color.naranja),
                disabledContentColor = colorResource(R.color.naranja)
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Arrow"
            )
        }
    }
}

@Composable
fun BackButton(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, bottom = 50.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        IconButton(
            modifier = Modifier.size(60.dp),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            },
            colors = IconButtonColors(
                containerColor = colorResource(R.color.naranja),
                contentColor = colorResource(R.color.white),
                disabledContainerColor = colorResource(R.color.naranja),
                disabledContentColor = colorResource(R.color.naranja)
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Arrow"
            )
        }
    }
}