package com.example.birds.presentation.levels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birds.R
import com.example.birds.domain.model.Levels
import com.example.birds.ui.theme.Dark
import com.example.birds.ui.theme.oswaldFontFamily

@Composable
fun LevelsScreen(onNavigateToHome: (String) -> Unit) {
    val levels = listOf(
        Levels("Beginner", R.drawable.level_beginner),
        Levels("Intermediate", R.drawable.level_intermediate),
        Levels("Expert", R.drawable.level_expert)
    )
    Scaffold(
        containerColor = Dark.Background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)) {
                items(levels) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        ),
                        onClick = {
                            onNavigateToHome.invoke(item.level)
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 36.dp),
                                text = item.level,
                                fontSize = 24.sp,
                                fontFamily = oswaldFontFamily,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                modifier = Modifier.size(60.dp),
                                painter = painterResource(id = item.image),
                                contentDescription = item.level
                            )
                        }
                    }
                }
            }
        }
    }
}