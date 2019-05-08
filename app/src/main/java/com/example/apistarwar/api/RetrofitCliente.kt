package com.example.apistarwar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {

    private const val url="https://swapi.co/api/"

    var retrofit= Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create(InterfaceApi::class.java)


}