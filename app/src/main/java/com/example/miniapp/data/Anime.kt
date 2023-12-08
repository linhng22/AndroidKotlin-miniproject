package com.example.miniapp.data

import com.google.gson.annotations.SerializedName

data class AnimeList(
    @SerializedName("data")
    val animeList : List<Anime>
)

data class Anime (
    @SerializedName("mal_id")
    val id: Int,

    val titles : ArrayList<AnimeTitle>,
    val images : AnimeImage,
    val episodes:String,
    val favorites:Int?,
    val synopsis : String,
    val year: String?,
    val score: Double?,
    val scored_by: Int?,
    val type: String?,
    val rank: Int?
)

data class AnimeImage(
    @SerializedName("jpg")
    val jpg : JPG
)

data class JPG(
    @SerializedName("image_url")
    val imageURL : String
)

data class AnimeTitle(
    @SerializedName("title")
    val title: String
)
