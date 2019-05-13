package com.example.apistarwar.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apistarwar.R
import com.example.apistarwar.activitys.SegundaVista
import com.example.apistarwar.data.People
import com.example.apistarwar.data.Planet
import kotlinx.android.synthetic.main.people_recycle_view_list.view.*
import kotlinx.android.synthetic.main.planet_recycle_view_list.view.*

class PlanetAdapter(val context: Context, val planet: Planet , val listPeople: MutableList<People>):  RecyclerView.Adapter<PlanetAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.planet_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       val people=listPeople[position]
        val text: String = "Name : " + planet.name +
                "\n" + "Rotacion Period : " + planet.rotation +
                "\n" + "Orbital Rotation : " + planet.orbital +
                "\n" + "diameter : " + planet.diameter +
                "\n" + "climate :  " + planet.climate +
                "\n" + "Gravity : " + planet.gravity +
                "\n" + "terrain " + planet.terrain +
                "\n" + "Surface " + planet.surfaceWater +
                "\n" + "population :  " + planet.population +
                "\n" + "residents :  " + people.name +
                "\n" + "Films :  " + planet.films.toString()
        holder.view.dataPlanet.text=text

    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
