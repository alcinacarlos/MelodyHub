package com.alcinacarlos.melodyhub.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.R

@Composable
fun SocialMediaButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialButton(
                iconRes = R.drawable.facebook,
                backgroundColor = Color(0xFF1877F2),
                contentDescription = "Facebook",
                modifier = Modifier.weight(1f)
            )
            SocialButton(
                iconRes = R.drawable.googleicon,
                backgroundColor = Color.White,
                contentDescription = "Google",
                modifier = Modifier.weight(1f),
                tint = false
            )
            SocialButton(
                iconRes = R.drawable.apple,
                backgroundColor = Color.White,
                contentDescription = "Apple",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SocialButton(
    iconRes: Int,
    backgroundColor: Color,
    contentDescription: String,
    modifier: Modifier = Modifier,
    tint: Boolean = true
) {
    Button(
        onClick = {  },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(12.dp))
    {
        if (tint){
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                tint = if (backgroundColor == Color.White) Color.Black else Color.White
            )
        }else{
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                tint = Color.Unspecified
            )
        }

    }
}
