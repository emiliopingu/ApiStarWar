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


class PeopleAdapter(val context: Context, val personajes: MutableList<People>) :
    RecyclerView.Adapter<PeopleAdapter.viewHolder>() {


    val listSpecies: ArrayList<String> = ArrayList()
    val listStarship: ArrayList<String> = ArrayList()
    val listVehicles: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.people_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val personaje = personajes[position]
        holder.view.nombreView.text = personaje.name
        holder.view.especieView.text = "Species"
        holder.view.vehiculoView.text = "Vehicles"
        holder.view.naveView.text = "StarShips"
        holder.view.planetaView.text = "HomeWorld"

        holder.view.planetaView.setOnClickListener {
            val intent1 = Intent(context, SegundaVista::class.java)
            intent1.putExtra("urlPlaneta", personaje.homeworld)
            context.startActivity(intent1)
        }
        holder.view.especieView.setOnClickListener {

            for (x in 0 until personaje.species!!.size) {
                listSpecies.add(personaje.species!![x])

                val intent2 = Intent(context, SegundaVista::class.java)
                intent2.putExtra("urlEspecie", listSpecies)
                context.startActivity(intent2)
            }
        }
        holder.view.vehiculoView.setOnClickListener {
            for (x in 0 until personaje.vehicles!!.size) {
                listVehicles.add(personaje.vehicles!![x])

                val intent3 = Intent(context, SegundaVista::class.java)
                intent3.putExtra("urlVehicles", listVehicles)
                context.startActivity(intent3)
            }
        }
        holder.view.naveView.setOnClickListener {
            for (x in 0 until personaje.starships!!.size) {
                listStarship.add(personaje.starships!![x])

                val intent4 = Intent(context, SegundaVista::class.java)
                intent4.putExtra("urlStarShips", listStarship)
                context.startActivity(intent4)
            }
        }


    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
