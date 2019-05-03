package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.apistarwar.R
import com.example.apistarwar.adapter.PeopleListAdapter
import com.example.apistarwar.api.RetrofitClient
import com.example.apistarwar.data.All
import com.example.apistarwar.data.Planet
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planeta)
    }



fun callApi(){
    RetrofitClient.service.getPlanet().enqueue(object : Callback<Planet> {
        override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
            if (response.isSuccessful) {

            }
        }

        override fun onFailure(call: Call<Planet>, t: Throwable) {

        }

    })
}

   /* fun inflater(){
        val layoutManager = LinearLayoutManager(thi)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = PeopleListAdapter()
        recyclerView.adapter = adapter

    }
    */
}
