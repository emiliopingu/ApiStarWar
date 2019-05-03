package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Planet (
    @SerializedName("name")
    @Expose
    var name:String?=null
)

