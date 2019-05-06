package com.example.apistarwar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apistarwar.R
import com.example.apistarwar.data.Planet
import kotlinx.android.synthetic.main.planeta_recycle_view_list.view.*

class PlanetaListAdapter(val context: Context,val planet:Planet):RecyclerView.Adapter<PlanetaListAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.planeta_recycle_view_list, parent, false)
        return viewHolder(view)
    }


    override fun onBindViewHolder(holder:viewHolder, p1: Int) {

    }

    override fun getItemCount(): Int {
            return 1
    }


    inner class viewHolder(val view: View) : RecyclerView.ViewHolder(view)

}