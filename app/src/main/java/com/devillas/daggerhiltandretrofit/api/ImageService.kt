package com.devillas.daggerhiltandretrofit.api

import com.devillas.daggerhiltandretrofit.model.ImageItems
import com.devillas.daggerhiltandretrofit.utile.Constance.CLIENT_ID
import com.devillas.daggerhiltandretrofit.utile.Constance.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Accept-version:vi","Authorization: Client-ID $CLIENT_ID")
    @GET(END_POINT)
    suspend fun getAllImage():Response<List<ImageItems>>
}