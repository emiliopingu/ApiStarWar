package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("count")
    @Expose
    var count: Int? = null,

    @SerializedName("previous")
    @Expose
    var next: String? = null,

    @SerializedName("next")
    @Expose
    var previous: Any? = null,


    @SerializedName("results")
    @Expose
    var people: List<People>? = null


)

