package com.D121211081.Disney.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Data(
    @SerialName("__v")
    val __v: Int,
    @SerialName("_id")
    val _id: Int,
    @SerialName("allies")
    val allies: List<String?>,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("enemies")
    val enemies: List<String?>,
    @SerialName("films")
    val films: List<String>,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("name")
    val name: String,
    @SerialName("parkAttractions")
    val parkAttractions: List<String>,
    @SerialName("shortFilms")
    val shortFilms: List<String?>,
    @SerialName("sourceUrl")
    val sourceUrl: String,
    @SerialName("tvShows")
    val tvShows: List<String>,
    @SerialName("updatedAt")
    val updatedAt: String,
    @SerialName("url")
    val url: String,
    @SerialName("videoGames")
    val videoGames: List<String>
):Parcelable