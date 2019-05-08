package com.example.apistarwar.activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.apistarwar.R

class SegundaVista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_vista)

        val urlHomework=intent.getStringExtra("urlPlaneta")
        val urlSpecies=intent.getStringArrayExtra("urlEspecie")
        val urlVehicles=intent.getStringArrayExtra("urlVehicles")
        val urlStarShips=intent.getStringArrayExtra("urlStarShips")


    }
}
