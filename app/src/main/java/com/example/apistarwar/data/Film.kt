package com.example.apistarwar.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Film (

     @SerializedName("title")
     @Expose
     var title:String?=null
 )
