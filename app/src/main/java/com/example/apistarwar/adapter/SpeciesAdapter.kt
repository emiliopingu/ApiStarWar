package com.example.apistarwar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apistarwar.R
import com.example.apistarwar.data.Planet
import com.example.apistarwar.data.Species
import kotlinx.android.synthetic.main.planet_recycle_view_list.view.*

class SpeciesAdapter (val context: Context, val specie: Species):  RecyclerView.Adapter<SpeciesAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.planet_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val text: String = "Name : " + specie.name +
                "\n" + "classification  : " + specie.classification +
                "\n" + "designation : " + specie.designation +
                "\n" + "Average height : " + specie.average_height +
                "\n" + "Skin colors :  " + specie.skin_colors +
                "\n" + "Hair colors : " + specie.hair_colors +
                "\n" + "Eye colors " + specie.eye_colors +
                "\n" + "Average lifwSpan " + specie.average_lifespan +
                "\n" + "Homeworld :  " + specie.homeworld +
                "\n" + "Language :  " + specie.language +
                "\n" + "People :  " + specie.people.toString() +
                "\n" + "Films : " + specie.films.toString()
        holder.view.dataPlanet.text=text

    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)
}