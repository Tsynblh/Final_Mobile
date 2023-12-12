package com.D121211081.Disney.data.response

import com.D121211081.Disney.data.models.Data
import com.D121211081.Disney.data.models.Disney
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.D121211081.Disney.data.models.Info

@Serializable
data class GetDisneyResponse(
    @SerialName("data")
    val data: List<Disney>,
    @SerialName("info")
    val info: Info
)