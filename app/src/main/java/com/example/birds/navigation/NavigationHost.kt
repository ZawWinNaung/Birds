package com.example.birds.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.birds.presentation.home.HomeScreen
import com.example.birds.presentation.levels.LevelsScreen

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