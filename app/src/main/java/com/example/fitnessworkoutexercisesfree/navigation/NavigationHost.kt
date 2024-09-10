package com.example.fitnessworkoutexercisesfree.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.fitnessworkoutexercisesfree.presentation.home.HomeScreen
import com.example.fitnessworkoutexercisesfree.presentation.levels.LevelsScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Levels
    ) {
        composable<Levels> {
            LevelsScreen(onNavigateToHome = { level ->
                navController.navigate(Home(level))
            })
        }
        composable<Home> { backStackEntry ->
            val home: Home = backStackEntry.toRoute()
            HomeScreen(home.level)
        }
    }
}