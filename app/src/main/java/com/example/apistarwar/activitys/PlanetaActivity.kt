package com.example.apistarwar.activitys

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apistarwar.R
import com.example.apistarwar.api.RetrofitClient
import com.example.apistarwar.data.Film
import com.example.apistarwar.data.Planet
import kotlinx.android.synthetic.main.activity_planeta.*
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
// implementar nuevallamada


    fun callApi(url: String) {
        RetrofitClient.service.getPlanet(url).enqueue(object : Callback<Planet> {
            override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                if (response.isSuccessful) {
                    Log.i("llamadaPlaneta", "Se ha llamado a planeta " + url)

                    var p: Planet = response.body()!!
                    val x: Int = p.films!!.size
                    for (film1 in 0 until x) {
                        RetrofitClient.service.getFilm(p.films!![film1]).enqueue(object : Callback<Film> {
                            override fun onResponse(call: Call<Film>, response: Response<Film>) {


                                val f: Film = response.body()!!

                                for(y in 0 until p.listFilms!!.size ){
                                 f.title= p.listFilms!![y].title


                                    val text: String = "Planet name: " + p.name +
                                            "\n" + " rotation period " + p.rotation +
                                            "\n" + " orbital rotation " + p.orbital +
                                            "\n" + " diameter " + p.diameter +
                                            "\n" + " climate " + p.climate +
                                            "\n" + " gravity: " + p.gravity +
                                            "\n" + " terrain: " + p.terrain +
                                            "\n" + " surface: " + p.surfaceWater +
                                            "\n" + "population " + p.population +
                                            "\n" + "residents " + p.residents +
                                            "\n" + " films " + p.listFilms!![film1].title

                                    tvPlanet.text = text
                                }








                            }

                            override fun onFailure(call: Call<Film>, t: Throwable) {
                                Log.i("llamadaPlaneta", "No se ha llamado a planeta-pelicula")
                            }

                        })

                    }


                }
            }

            override fun onFailure(call: Call<Planet>, t: Throwable) {
                Log.i("llamadaPlanetaFallida", "No se ha llamado a planeta")
            }

        })
    }


}


