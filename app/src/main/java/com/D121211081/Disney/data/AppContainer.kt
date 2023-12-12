package com.D121211088.news.data

import com.D121211081.Disney.data.source.remote.ApiService
import com.D121211081.Disney.data.repository.DisneyRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppCointainer {
    val DisneyRepository: DisneyRepository
}

class DefaultAppContainer: AppCointainer {

    private val BASE_URL = "https://api.disneyapi.dev"
    val json = Json {
        ignoreUnknownKeys = true
    }

    // authorization token
//    private val AUTH_TOKEN = "Xo1rp9iE4pVuFIZkC7sH"

    private val retrofit = Retrofit.Builder()
//        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val DisneyRepository: DisneyRepository
        get() = DisneyRepository(retrofitService)
}