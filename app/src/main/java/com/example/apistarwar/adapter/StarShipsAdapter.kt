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
import com.example.apistarwar.data.Starship
import kotlinx.android.synthetic.main.activity_segunda_vista.*
import kotlinx.android.synthetic.main.people_recycle_view_list.view.*
import kotlinx.android.synthetic.main.planet_recycle_view_list.view.*
import kotlinx.android.synthetic.main.starships_recycle_view_list.view.*

class StarShipsAdapter(val context: Context, val naves:MutableList<Starship>):  RecyclerView.Adapter<StarShipsAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.planet_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val nave = naves[position]
        val text: String = "Name : " +nave.name+
                "\n" + "Model : " + nave.model +
                "\n" + "Manufacture : " + nave.manufacturer +
                "\n" + "Cost_in_credits : " + nave.cost_in_credits +
                "\n" + "Length :  " + nave.length +
                "\n" + "Max_atmosphering_speed : " + nave.max_atmosphering_speed +
                "\n" + "Crew " + nave.crew +
                "\n" + "Passengers " + nave.passengers +
                "\n" + "Cargo_capacity :  " + nave.cargo_capacity +
                "\n" + "Consumables :  " + nave.consumables +
                "\n" + "Hyperdrive_rating :  " + nave.hyperdrive_rating +
                "\n" + "MGLT :  " + nave.MGLT +
                "\n" + "Starship_class :  " + nave.starship_class+
                "\n" + "Pilots :  " + nave.pilots.toString()+
                "\n" + "Films :  " + nave.films.toString()
          holder.view.dataPlanet.text=text

    }


    override fun getItemCount(): Int {
     return naves.size

    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}

