package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.net.URL

class People(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("height")
    @Expose
    var height: String? = null,

    @SerializedName("mass")
    @Expose
    var mass: String? = null,

    @SerializedName("hair_color")
    @Expose
    var hairColor: String? = null,


    @SerializedName("skin_color")
    @Expose
    var skinColor: String? = null,


    @SerializedName("eye_color")
    @Expose
    var eyeColor: String? = null,


    @SerializedName("birth_year")
    @Expose
    var birthYear: String? = null,


    @SerializedName("gender")
    @Expose
    var gender: String? = null,


    @SerializedName("homeworld")
    @Expose
    var homeworld: String? = null,


    @SerializedName("films")
    @Expose
    var films: List<String>? = null,


    @SerializedName("species")
    @Expose
    var species: List<String>? = null,


    @SerializedName("vehicles")
    @Expose
    var vehicles: List<String>? = null,


    @SerializedName("starships")
    @Expose
    var starships: List<String>? = null,


    @SerializedName("created")
    @Expose
    var created: String? = null,


    @SerializedName("edited")
    @Expose
    var edited: String? = null,


    @SerializedName("url")
    @Expose
    var url: URL? = null,

    var Planet: Planet? = null


)