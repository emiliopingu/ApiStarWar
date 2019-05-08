package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URL

data class Film(

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("episode_id")
    @Expose
    var episode_id: Int? = null,

    @SerializedName("opening_crawl")
    @Expose
    var opening_crawl: String? = null,

    @SerializedName("director")
    @Expose
    var director: String? = null,

    @SerializedName("producer")
    @Expose
    var producer: String? = null,

    @SerializedName("release_date")
    @Expose
    var release_date: String? = null,

    @SerializedName("characters")
    @Expose
    var characters: List<String>? = null,

    @SerializedName("planets")
    @Expose
    var planets: List<String>? = null,

    @SerializedName("starships")
    @Expose
    var starships: List<String>? = null,

    @SerializedName("vehicles")
    @Expose
    var vehicles: List<String>? = null,

    @SerializedName("species")
    @Expose
    var species: List<String>? = null,

    @SerializedName("created")
    @Expose
    var created: String? = null,


    @SerializedName("edited")
    @Expose
    var edited: String? = null,


    @SerializedName("url")
    @Expose
    var url: URL? = null
)
