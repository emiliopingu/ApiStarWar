package com.example.apistarwar.activitys

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.apistarwar.R
import com.example.apistarwar.adapter.PeopleListAdapter
import com.example.apistarwar.adapter.PlanetaListAdapter
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
        val i: Intent = intent
        val url = i.getStringExtra("urlPlaneta")

        callApi(url)
    }


    fun callApi(url: String) {
        RetrofitClient.service.getPlanet(url).enqueue(object : Callback<Planet> {
            override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                if (response.isSuccessful) {
                    Log.i("llamadaPlaneta", "Se ha llamado a planeta")
                    inflater(response.body())
                }
            }

            override fun onFailure(call: Call<Planet>, t: Throwable) {
                Log.i("llamadaPlanetaFallida", "No se ha llamado a planeta")
            }

        })
    }

    fun inflater(planet:Planet?) {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = PlanetaListAdapter(this@PlanetaActivity,planet)
        recyclerView.adapter = adapter

    }

}
