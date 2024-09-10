package com.example.birds.domain.model


import com.google.gson.annotations.SerializedName

data class Bird(
    @SerializedName("speciesCode")
    val speciesCode: String?,
    @SerializedName("comName")
    val comName: String?,
    @SerializedName("sciName")
    val sciName: String?,
    @SerializedName("locId")
    val locId: String?,
    @SerializedName("locName")
    val locName: String?,
    @SerializedName("obsDt")
    val obsDt: String?,
    @SerializedName("howMany")
    val howMany: Int?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?,
    @SerializedName("obsValid")
    val obsValid: Boolean?,
    @SerializedName("obsReviewed")
    val obsReviewed: Boolean?,
    @SerializedName("locationPrivate")
    val locationPrivate: Boolean?,
    @SerializedName("subId")
    val subId: String?
)