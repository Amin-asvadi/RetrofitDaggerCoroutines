package com.devillas.daggerhiltandretrofit.model


import com.google.gson.annotations.SerializedName

data class ImageItems(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("urls")
    val urls: Urls
)