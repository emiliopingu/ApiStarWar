package com.example.apistarwar.api

import com.example.apistarwar.data.All
import com.example.apistarwar.data.People
import com.example.apistarwar.data.Planet
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceStarWarApi {

    @GET("people") fun getPeople(): Call<All>
    @GET("planet") fun getPlanet(): Call<Planet>

}