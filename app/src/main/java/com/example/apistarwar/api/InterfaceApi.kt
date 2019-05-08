package com.example.apistarwar.api

import com.example.apistarwar.data.All
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceApi {

    @GET("people") fun getPeople(): Call<All>

}