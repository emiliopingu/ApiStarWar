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
import kotlinx.android.synthetic.main.people_recycle_view_list.view.*


class PeopleAdapter(val context: Context, val personajes:MutableList<People>):  RecyclerView.Adapter<PeopleAdapter.viewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.people_recycle_view_list, parent, false)
            return viewHolder(view)
        }


        override fun onBindViewHolder(holder: viewHolder, position: Int) {
            val personaje = personajes[position]
            holder.view.nombreView.text = personaje.name
            holder.view.especieView.text = personaje.species.toString()
            holder.view.vehiculoView.text = personaje.vehicles.toString()
            holder.view.naveView.text = personaje.starships.toString()
            holder.view.planetaView.text = personaje.homeworld

            holder.view.planetaView.setOnClickListener {
                val intent = Intent(context, SegundaVista::class.java)
                intent.putExtra("urlEspecie", personaje.species.toString())
                context.startActivity(intent)
            }
            holder.view.planetaView.setOnClickListener {
                val intent = Intent(context, SegundaVista::class.java)
                intent.putExtra("urlVehicles",personaje.vehicles.toString())
                context.startActivity(intent)
            }
            holder.view.planetaView.setOnClickListener {
                val intent = Intent(context, SegundaVista::class.java)
                intent.putExtra("urlStarShips", personaje.starships.toString())
                context.startActivity(intent)
            }
            holder.view.planetaView.setOnClickListener {
                val intent = Intent(context, SegundaVista::class.java)
                intent.putExtra("urlPlaneta", personaje.homeworld)
                context.startActivity(intent)
            }


        }

        override fun getItemCount(): Int {
            return personajes.size
        }

        inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
    }
