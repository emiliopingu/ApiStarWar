package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.apistarwar.R
import com.example.apistarwar.adapter.*
import com.example.apistarwar.api.RetrofitCliente
import com.example.apistarwar.data.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_segunda_vista.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SegundaVista : AppCompatActivity() {

    val listStarship: MutableList<Starship> = ArrayList()
    val listVehicles: MutableList<Vehicles> = ArrayList()
    val listResidents: MutableList<People> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_vista)

        val urlHomework = intent.getStringExtra("urlPlaneta")
        val urlSpecies = intent.getStringArrayListExtra("urlEspecie")
        val urlStarShips = intent.getStringArrayListExtra("urlStarShips")
        val urlVehicles = intent.getStringArrayListExtra("urlVehicles")




        if (urlHomework != null) {
            RetrofitCliente.service.getPlanet(urlHomework).enqueue(object : Callback<Planet> {
                override fun onFailure(call: Call<Planet>, t: Throwable) {
                    Log.i("llamada3", "No Ha cogido datos de planeta")

                }

                override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                    Log.i("llamada4", " ha cogido datos de planeta")
                    if (response.isSuccessful) {
                        val planet = response.body()!!
                        for (x in 0 until planet.residents!!.size) {
                            RetrofitCliente.service.getResidents(planet.residents!![x])
                                .enqueue(object : Callback<People> {
                                    override fun onResponse(call: Call<People>, response: Response<People>) {
                                        Log.i("llamada9", " ha cogido datos de planeta-people")
                                        val resident = response.body()
                                        for (y in 0 until planet.residents!!.size) {
                                            resident?.let { listResidents.add(it) }

                                        }
                                        val layoutManager = LinearLayoutManager(this@SegundaVista)
                                        layoutManager.orientation = LinearLayoutManager.VERTICAL
                                        recycleViewPlanet.layoutManager = layoutManager
                                        val adapter = PlanetAdapter(this@SegundaVista, planet, listResidents)
                                        recycleViewPlanet.adapter = adapter
                                    }

                                    override fun onFailure(call: Call<People>, t: Throwable) {
                                        Log.i("llamada10", " No ha cogido datos de planeta-people")
                                    }

                                })


                        }


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

                            val layoutManager = LinearLayoutManager(this@SegundaVista)
                            layoutManager.orientation = LinearLayoutManager.VERTICAL
                            recycleViewPlanet.layoutManager = layoutManager
                            val adapter = SpeciesAdapter(this@SegundaVista, species)
                            recycleViewPlanet.adapter = adapter


                        }


                    }

                })
            }

        }

        if (urlStarShips != null) {
            for (x in 0 until urlStarShips.size) {
                RetrofitCliente.service.getStarShip(urlStarShips[x]).enqueue(object : Callback<Starship> {
                    override fun onFailure(call: Call<Starship>, t: Throwable) {
                        Log.i("llamada7", "No Ha cogido datos de nave")

                    }

                    override fun onResponse(call: Call<Starship>, response: Response<Starship>) {
                        Log.i("llamada8", " ha cogido datos de nave")
                        if (response.isSuccessful) {
                            val nave = response.body()!!
                            listStarship.add(nave)
                            inflarListStarship()
                        }


                    }

                })
            }
        }

        if (urlVehicles != null) {
            for (x in 0 until urlVehicles.size) {
                RetrofitCliente.service.getVehicles(urlVehicles[x]).enqueue(object : Callback<Vehicles> {
                    override fun onFailure(call: Call<Vehicles>, t: Throwable) {
                        Log.i("llamada5", "No Ha cogido datos de Vehiculo")

                    }

                    override fun onResponse(call: Call<Vehicles>, response: Response<Vehicles>) {
                        Log.i("llamada6", " ha cogido datos de Vehiculo")
                        if (response.isSuccessful) {
                            val vehiculo = response.body()!!
                            listVehicles.add(vehiculo)
                            inflarListVehicles()


                        }


                    }

                })
            }
        }
    }

    fun inflarListStarship() {
        val layoutManager = LinearLayoutManager(this@SegundaVista)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleViewPlanet.layoutManager = layoutManager
        val adapter = StarShipsAdapter(this@SegundaVista, listStarship)
        recycleViewPlanet.adapter = adapter
    }

    fun inflarListVehicles() {
        val layoutManager = LinearLayoutManager(this@SegundaVista)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleViewPlanet.layoutManager = layoutManager
        val adapter = VehiclesAdapter(this@SegundaVista, listVehicles)
        recycleViewPlanet.adapter = adapter
    }
}


