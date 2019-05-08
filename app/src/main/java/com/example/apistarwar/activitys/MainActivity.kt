package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.apistarwar.R
import com.example.apistarwar.adapter.PeopleAdapter
import com.example.apistarwar.api.RetrofitCliente
import com.example.apistarwar.data.All
import com.example.apistarwar.data.People
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    val listPeople: MutableList<People> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       callApi()

    }

    fun inflater(){
        val layoutManager = LinearLayoutManager(this@MainActivity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = PeopleAdapter(this@MainActivity, listPeople)
        recyclerView.adapter = adapter

    }
    fun callApi() {
        RetrofitCliente.service.getPeople().enqueue(object : Callback<All> {
            override fun onResponse(call: Call<All>, response: Response<All>) {
                Log.i("llamada1", "La llamada a la api ha funcionado")

            inflater()
            }

            override fun onFailure(call: Call<All>, t: Throwable) {
                Log.i("llamada2", "La llamada a la api no ha funcionado")
            }


        })
    }




}

