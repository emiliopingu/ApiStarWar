package com.example.apistarwar.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URL

data class Planet(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("rotation_period")
    @Expose
    var rotation: String? = null,

    @SerializedName("orbital_period")
    @Expose
    var orbital: String? = null,

    @SerializedName("diameter")
    @Expose
    var diameter: String? = null,

    @SerializedName("climate")
    @Expose
    var climate: String? = null,

    @SerializedName("gravity")
    @Expose
    var gravity: String? = null,

    @SerializedName("terrain")
    @Expose
    var terrain: String? = null,

    @SerializedName("surface_water")
    @Expose
    var surfaceWater: String? = null,

    @SerializedName("population")
    @Expose
    var population: String? = null,

    @SerializedName("residents")
    @Expose
    var residents: List<String>? = null,



    var peoples: People?=null,

    @SerializedName("films")
    @Expose
    var films: List<String>? = null,

    var listFilms:List<Film>?=null,


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

