package com.D121211081.Disney.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Info(
    val count: Int,
    val nextPage: String,
    val previousPage: Int?,
    val totalPages: Int
):Parcelable