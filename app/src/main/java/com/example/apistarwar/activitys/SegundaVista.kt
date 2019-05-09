package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.apistarwar.R
import com.example.apistarwar.adapter.PeopleAdapter
import com.example.apistarwar.adapter.StarShipsAdapter
import com.example.apistarwar.api.RetrofitCliente
import com.example.apistarwar.data.Planet
import com.example.apistarwar.data.Species
import com.example.apistarwar.data.Starship
import com.example.apistarwar.data.Vehicles
import kotlinx.android.synthetic.main.activity_main.*
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
        val urlStarShips = intent.getStringArrayListExtra("urlStarShips")
        val urlVehicles = intent.getStringArrayListExtra("urlStarShips")



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
            for (x in 0 until urlSpecies.size) {
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

        if (urlStarShips != null) {
            for (x in 0 until urlStarShips.size) {
                RetrofitCliente.service.getStarShip(urlStarShips[x]).enqueue(object : Callback<Starship> {
                    override fun onFailure(call: Call<Starship>, t: Throwable) {
                        Log.i("llamada5", "No Ha cogido datos de Especie")

                    }

                    override fun onResponse(call: Call<Starship>, response: Response<Starship>) {
                        Log.i("llamada4", " ha cogido datos de Especie")
                        if (response.isSuccessful) {
                            val nave = response.body()!!
                            val text: String = "Name : " + nave.name +
                                    "\n" + "Model : " + nave.model +
                                    "\n" + "Manufacturer : " + nave.manufacturer +
                                    "\n" + "cost_in_credits : " + nave.cost_in_credits +
                                    "\n" + "Lenght : " + nave.length +
                                    "\n" + "max_atmosphering_speed : " + nave.max_atmosphering_speed +
                                    "\n" + "crew : " + nave.crew +
                                    "\n" + "passengers : " + nave.passengers +
                                    "\n" + "cargo_capacity : " + nave.cargo_capacity +
                                    "\n" + "consumables : " + nave.consumables +
                                    "\n" + "hyperdrive_rating : " + nave.hyperdrive_rating +
                                    "\n" + "MGLT : " + nave.MGLT +
                                    "\n" + "starship_class : " + nave.starship_class +
                                    "\n" + "Pilots : " + nave.pilots +
                                    "\n" + "Films : " + nave.films.toString()
                            tv.text = text


                        }


                    }

                })
            }
        }

        if (urlVehicles != null) {
            for (x in 0 until urlVehicles.size) {
                RetrofitCliente.service.getVehicles(urlVehicles[x]).enqueue(object : Callback<Vehicles> {
                    override fun onFailure(call: Call<Vehicles>, t: Throwable) {
                        Log.i("llamada5", "No Ha cogido datos de Especie")

                    }

                    override fun onResponse(call: Call<Vehicles>, response: Response<Vehicles>) {
                        Log.i("llamada4", " ha cogido datos de Especie")
                        if (response.isSuccessful) {
                            val vehiculo = response.body()!!
                            val text: String = "Name : " + vehiculo.name +
                                    "\n" + "Model : " + vehiculo.model +
                                    "\n" + "Manufacturer : " + vehiculo.manufacturer +
                                    "\n" + "cost_in_credits : " + vehiculo.cost_in_credits +
                                    "\n" + "Lenght : " + vehiculo.length +
                                    "\n" + "max_atmosphering_speed : " + vehiculo.max_atmosphering_speed +
                                    "\n" + "crew : " + vehiculo.crew +
                                    "\n" + "passengers : " + vehiculo.passengers +
                                    "\n" + "cargo_capacity : " + vehiculo.cargo_capacity +
                                    "\n" + "consumables : " + vehiculo.consumables +
                                    "\n" + "hyperdrive_rating : " + vehiculo.vehicle_class +
                                    "\n" + "Pilots : " +vehiculo.pilots +
                                    "\n" + "Films : " + vehiculo.films.toString()
                            tv.text = text


                        }


                    }

                })
            }
        }
    }


}