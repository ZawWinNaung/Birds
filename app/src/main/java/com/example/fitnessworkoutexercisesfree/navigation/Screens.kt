package com.example.fitnessworkoutexercisesfree.navigation

import kotlinx.serialization.Serializable


@Serializable
object Levels

@Serializable
data class Home(
    val level: String
)