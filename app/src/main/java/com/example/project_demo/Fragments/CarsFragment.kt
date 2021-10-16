package com.example.project_demo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.project_demo.Adapters.CarsAdapter
import com.example.project_demo.Models.Cars
import com.example.project_demo.R
import kotlinx.android.synthetic.main.fragment_cars.*

class CarsFragment : Fragment(R.layout.fragment_cars) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CarsAdapter(listOfCars())
        rvcars.adapter = adapter
        rvcars.layoutManager = StaggeredGridLayoutManager(3,LinearLayoutManager.HORIZONTAL)
    }

    fun listOfCars():MutableList<Cars>{
        val car1 = Cars("Inglo",getResources().getDrawable(R.drawable.civic),"220 Model","Daily")
        val car2 = Cars("Inglo",getResources().getDrawable(R.drawable.mercindes),"220 Model","Daily")
        val car3 = Cars("Inglo",getResources().getDrawable(R.drawable.aed1850),"220 Model","Daily")
        val car4 = Cars("Inglo",getResources().getDrawable(R.drawable.aed380),"220 Model","Daily")
        val car5 = Cars("Inglo",getResources().getDrawable(R.drawable.alpharomeo),"220 Model","Daily")
        val car6 = Cars("Inglo",getResources().getDrawable(R.drawable.rangeroversport),"220 Model","Daily")
        val car7 = Cars("Inglo",getResources().getDrawable(R.drawable.mercindes),"220 Model","Daily")
        val car8 = Cars("Inglo",getResources().getDrawable(R.drawable.aed1850),"220 Model","Daily")
        val car9 = Cars("Inglo",getResources().getDrawable(R.drawable.aed380),"220 Model","Daily")
        val car10 = Cars("Inglo",getResources().getDrawable(R.drawable.alpharomeo),"220 Model","Daily")
        val car11 = Cars("Inglo",getResources().getDrawable(R.drawable.civic),"220 Model","Daily")
        val car12 = Cars("Inglo",getResources().getDrawable(R.drawable.alpharomeo),"220 Model","Daily")



        val carlist = mutableListOf<Cars>()
        carlist.add(car1)
        carlist.add(car2)
        carlist.add(car3)
        carlist.add(car4)
        carlist.add(car5)
        carlist.add(car6)
        carlist.add(car7)
        carlist.add(car8)
        carlist.add(car9)
        carlist.add(car10)
        carlist.add(car11)
        carlist.add(car12)



        return carlist
    }
}

