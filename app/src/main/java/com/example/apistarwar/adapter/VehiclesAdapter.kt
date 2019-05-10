package com.example.apistarwar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apistarwar.R
import com.example.apistarwar.data.Starship
import com.example.apistarwar.data.Vehicles
import kotlinx.android.synthetic.main.planet_recycle_view_list.view.*

class VehiclesAdapter (val context: Context, val vehiculos: MutableList<Vehicles>):  RecyclerView.Adapter<VehiclesAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.planet_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val v=vehiculos[position]
        val text: String = "Name : " +v.name+
                "\n" + "Model : " + v.model +
                "\n" + "Manufacture : " + v.manufacturer +
                "\n" + "Cost_in_credits : " + v.cost_in_credits +
                "\n" + "Length :  " + v.length +
                "\n" + "Max_atmosphering_speed : " +v.max_atmosphering_speed +
                "\n" + "Crew " + v.crew +
                "\n" + "Passengers " + v.passengers +
                "\n" + "Cargo_capacity :  " + v.cargo_capacity +
                "\n" + "Consumables :  " + v.consumables +
                "\n" + "Pilots :  " + v.pilots.toString()+
                "\n" + "Films :  " + v.films.toString()
        holder.view.dataPlanet.text=text

    }


    override fun getItemCount(): Int {
        return vehiculos.size
    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
