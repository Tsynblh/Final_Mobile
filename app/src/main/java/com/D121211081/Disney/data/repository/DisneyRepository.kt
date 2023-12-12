package com.D121211081.Disney.data.repository

import com.D121211081.Disney.data.source.remote.ApiService
import com.D121211081.Disney.data.response.GetDisneyResponse

class DisneyRepository(private val apiService: ApiService) {

    suspend fun getDisney(): GetDisneyResponse {
        return apiService.getDisney()
    }
}