package com.example.miniapp.data

enum class APIEndPoint (val url:String){
    BASE_URL("https://api.jikan.moe/v4"),
    ANIME("${BASE_URL.url}/anime"),
    FIELDS1("${ANIME.url}?field=mal_id, titles, images, episodes, favorites, synopsis, year")
//    FIELDS1("${ANIME.url}?field=mal_id, year")

}