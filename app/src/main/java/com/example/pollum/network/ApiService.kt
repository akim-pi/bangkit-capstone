package com.example.pollum.network

import com.example.pollum.data.BeeScanResponse
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import okhttp3.MultipartBody
import retrofit2.http.Header

interface ApiService {
    @Multipart
    @POST("bee")
    suspend fun scanBeeImage(
        @Part image: MultipartBody.Part
    ): BeeScanResponse
}