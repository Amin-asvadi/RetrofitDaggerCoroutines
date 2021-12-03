package com.devillas.daggerhiltandretrofit.repository

import com.devillas.daggerhiltandretrofit.api.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(private val api: ImageService) {

    suspend fun getAllImage() = api.getAllImage()
}