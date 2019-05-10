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
        val vehiculo=vehiculos[position]
        val text: String = "Name : " +vehiculo.name+
                "\n" + "Model : " + vehiculo.model +
                "\n" + "Manufacture : " + vehiculo.manufacturer +
                "\n" + "Cost_in_credits : " + vehiculo.cost_in_credits +
                "\n" + "Length :  " + vehiculo.length +
                "\n" + "Max_atmosphering_speed : " +vehiculo.max_atmosphering_speed +
                "\n" + "Crew " + vehiculo.crew +
                "\n" + "Passengers " + vehiculo.passengers +
                "\n" + "Cargo_capacity :  " + vehiculo.cargo_capacity +
                "\n" + "Consumables :  " + vehiculo.consumables +
                "\n" + "Pilots :  " + vehiculo.pilots.toString()+
                "\n" + "Films :  " + vehiculo.films.toString()
        holder.view.dataPlanet.text=text

    }


    override fun getItemCount(): Int {
        return vehiculos.size

    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
