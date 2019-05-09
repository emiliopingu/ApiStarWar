package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apistarwar.R
import com.example.apistarwar.api.RetrofitCliente
import com.example.apistarwar.data.Planet
import com.example.apistarwar.data.Species
import kotlinx.android.synthetic.main.activity_segunda_vista.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SegundaVista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_vista)

        val urlHomework = intent.getStringExtra("urlPlaneta")
        val urlSpecies = intent.getStringArrayListExtra("urlEspecie")
        val urlVehicles = intent.getStringArrayListExtra("urlVehicles")
        val urlStarShips = intent.getStringArrayListExtra("urlStarShips")


        if (urlHomework != null) {
            RetrofitCliente.service.getPlanet(urlHomework).enqueue(object : Callback<Planet> {
                override fun onFailure(call: Call<Planet>, t: Throwable) {
                    Log.i("llamada3", "No Ha cogido datos de planeta")

                }

                override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                    Log.i("llamada4", " ha cogido datos de planeta")
                    if (response.isSuccessful) {
                        val planet = response.body()!!
                        val text: String = "Name : " + planet.name +
                                "\n" + "Rotacion Period : " + planet.rotation +
                                "\n" + "Orbital Rotation : " + planet.orbital +
                                "\n" + "diameter : " + planet.diameter +
                                "\n" + "climate :  " + planet.climate +
                                "\n" + "Gravity : " + planet.gravity +
                                "\n" + "terrain " + planet.terrain +
                                "\n" + "Surface " + planet.surfaceWater +
                                "\n" + "population :  " + planet.population +
                                "\n" + "residents :  " + planet.residents.toString() +
                                "\n" + "Films :  " + planet.films.toString()
                        tv.text = text


                    }


                }

            })
        }

        if (urlSpecies != null) {
            for( x in 0 until urlSpecies.size){
                RetrofitCliente.service.getSpecies(urlSpecies[x]).enqueue(object : Callback<Species> {
                    override fun onFailure(call: Call<Species>, t: Throwable) {
                        Log.i("llamada5", "No Ha cogido datos de Especie")

                    }

                    override fun onResponse(call: Call<Species>, response: Response<Species>) {
                        Log.i("llamada4", " ha cogido datos de Especie")
                        if (response.isSuccessful) {
                            val species = response.body()!!
                            val text: String = "Name : " + species.name +
                                    "\n" + "classification  : " + species.classification +
                                    "\n" + "designation : " + species.designation +
                                    "\n" + "Average height : " + species.average_height +
                                    "\n" + "Skin colors :  " + species.skin_colors +
                                    "\n" + "Hair colors : " + species.hair_colors +
                                    "\n" + "Eye colors " + species.eye_colors +
                                    "\n" + "Average lifwSpan " + species.average_lifespan +
                                    "\n" + "Homeworld :  " + species.homeworld +
                                    "\n" + "Language :  " + species.language +
                                    "\n" + "People :  " + species.people.toString() +
                                    "\n" + "Films : " + species.films.toString()
                            tv.text = text


                        }


                    }

                })
            }

        }

        if(urlStarShips!=null){
                for(x in 0 until urlStarShips.size){
                    RetrofitCliente.service.getStarShip(urlStarShips[x])
                }
        }

        if(urlVehicles!=null){

        }
    }

}