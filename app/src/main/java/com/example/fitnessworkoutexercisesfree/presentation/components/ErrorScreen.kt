package com.example.fitnessworkoutexercisesfree.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessworkoutexercisesfree.R
import com.example.fitnessworkoutexercisesfree.ui.theme.Dark
import com.example.fitnessworkoutexercisesfree.ui.theme.darkShadow
import com.example.fitnessworkoutexercisesfree.ui.theme.lightShadow
import com.example.fitnessworkoutexercisesfree.ui.theme.oswaldFontFamily
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner
import retrofit2.HttpException

@Composable
fun ErrorScreen(error: Throwable) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark.Background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardColors(
                    containerColor = Dark.Background,
                    contentColor = Dark.Background,
                    disabledContentColor = Dark.Background,
                    disabledContainerColor = Dark.Background
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .neu(
                        lightShadowColor = lightShadow(),
                        darkShadowColor = darkShadow(),
                        shadowElevation = 6.dp,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(12.dp)),
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_error),
                        contentDescription = "Error Icon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .size(48.dp)
                    )
                    if (error is HttpException) {
                        Text(
                            text = error.code().toString(),
                            fontFamily = oswaldFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            fontStyle = FontStyle.Italic,
                            color = Dark.TextColor
                        )
                    }
                    Text(
                        text = error.message ?: "Unknown Error",
                        fontFamily = oswaldFontFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        color = Dark.TextColor,
                        fontSize = 16.sp, modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }

    }
}