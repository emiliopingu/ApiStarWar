package com.example.apistarwar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.example.apistarwar.api.RetrofitClient
import com.example.apistarwar.data.All
import com.example.apistarwar.data.People
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val list: MutableList<People> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = "Enciclopedia de STW"
        actionBar.elevation = 5.0F
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)
        CallApi()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun CallApi() {
        RetrofitClient.service.getPeople().enqueue(object : Callback<All> {
            override fun onResponse(call: Call<All>, response: Response<All>) {

                if (response.isSuccessful) {
                    val i: Int = response.body()!!.people!!.size
                    for (character in 0 until i) {
                        list.add(response.body()!!.people!![character])
                        Log.i("tag1", "Se ha añadidio")
                    }
                }
            }

            override fun onFailure(call: Call<All>, t: Throwable) {
                Log.i("falloCallback", "Ha fallado el Callback<All")
                Toast.makeText(this@MainActivity, "No se pudo conectar con la API", Toast.LENGTH_LONG)
            }

        })
    }

}

