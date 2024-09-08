package com.example.fitnessworkoutexercisesfree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fitnessworkoutexercisesfree.navigation.Home
import com.example.fitnessworkoutexercisesfree.navigation.Levels
import com.example.fitnessworkoutexercisesfree.navigation.NavigationHost
import com.example.fitnessworkoutexercisesfree.presentation.home.HomeScreen
import com.example.fitnessworkoutexercisesfree.presentation.levels.LevelsScreen
import com.example.fitnessworkoutexercisesfree.ui.theme.FitnessWorkoutExercisesFreeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessWorkoutExercisesFreeTheme {
                NavigationHost()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessWorkoutExercisesFreeTheme {
        Greeting("Android")
    }
}