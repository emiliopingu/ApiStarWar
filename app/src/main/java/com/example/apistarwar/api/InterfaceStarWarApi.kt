package com.example.apistarwar.api

import com.example.apistarwar.data.All
import com.example.apistarwar.data.People
import com.example.apistarwar.data.Planet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface InterfaceStarWarApi {

    @GET("people") fun getPeople(): Call<All>
    @GET() fun getPlanet(@Url URL:String): Call<Planet>


}