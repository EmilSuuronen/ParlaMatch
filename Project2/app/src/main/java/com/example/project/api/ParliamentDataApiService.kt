package com.example.project.api

import com.example.project.data.Mep
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/* Emil Suuronen - 1909931
30.9.2022
 */

//Api service for fetching the data from internet
object MepApi {

    private const val BASE_URL =
        "https://users.metropolia.fi/~peterh/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : ParlamentDataApiService = retrofit.create(ParlamentDataApiService::class.java)
}

interface ParlamentDataApiService {
    @GET("mps.json")
    suspend fun getMepData(): List<Mep>
}