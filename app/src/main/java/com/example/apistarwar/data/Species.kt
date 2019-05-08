package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URL

data class Species(

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("classification")
    @Expose
    var classification: String? = null,

    @SerializedName("designation")
    @Expose
    var designation: String? = null,

    @SerializedName("average_height")
    @Expose
    var average_height: String? = null,

    @SerializedName("skin_colors")
    @Expose
    var skin_colors: String? = null,

    @SerializedName("hair_colors")
    @Expose
    var hair_colors: String? = null,

    @SerializedName("eye_colors")
    @Expose
    var eye_colors: String? = null,

    @SerializedName("average_lifespan")
    @Expose
    var average_lifespan: String? = null,

    @SerializedName("homeworld")
    @Expose
    var homeworld: String? = null,

    @SerializedName("language")
    @Expose
    var language: String? = null,

    @SerializedName("people")
    @Expose
    var people: List<String>? = null,

    @SerializedName("films")
    @Expose
    var films: List<String>? = null,


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
