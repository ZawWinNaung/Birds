package com.example.birds.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    @SerializedName("name")
    val name: String?,
    @SerializedName("force")
    val force: String?,
    @SerializedName("level")
    val level: String?,
    @SerializedName("mechanic")
    val mechanic: String?,
    @SerializedName("equipment")
    val equipment: String?,
    @SerializedName("primaryMuscles")
    val primaryMuscles: List<String?>?,
    @SerializedName("secondaryMuscles")
    val secondaryMuscles: List<String?>?,
    @SerializedName("instructions")
    val instructions: List<String?>?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("images")
    val images: List<String?>?,
    @SerializedName("id")
    val id: String?
)