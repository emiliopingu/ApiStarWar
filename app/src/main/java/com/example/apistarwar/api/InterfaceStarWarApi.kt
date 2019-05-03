package com.example.apistarwar.api

import com.example.apistarwar.data.All
import com.example.apistarwar.data.People
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceStarWarApi {

    @GET("people") fun getPeople(): Call<All>
}