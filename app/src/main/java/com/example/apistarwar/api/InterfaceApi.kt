package com.example.apistarwar.api

import com.example.apistarwar.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface InterfaceApi {

    @GET("people") fun getPeople(): Call<All>
    @GET fun getPlanet(@Url url:String): Call<Planet>
    @GET fun getFilm(@Url url:List<String>): Call<Film>
    @GET fun getSpecies(@Url url:String): Call<Species>
    @GET fun getStarShip(@Url url:String): Call<Starship>
    @GET fun getVehicles(@Url url:String): Call<Vehicles>

}