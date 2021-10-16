package com.example.project_demo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_demo.Models.Cars
import com.example.project_demo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.car2text2
import kotlinx.android.synthetic.main.vehicleitems.view.*

class CarsAdapter(
    var cars : List<Cars>
    ) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>(){
        inner class CarsViewHolder(carsView: View) : RecyclerView.ViewHolder(carsView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.vehicleitems,parent,false)
            return CarsViewHolder(view)
        }

        override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
            holder.itemView.apply {
                ivcar222.setImageDrawable(cars[position].picture)
                car2text22.text = cars[position].car2text2
                tvcartextsub22.text = cars[position].tvcartextsub2
                tvcartextduration22.text = cars[position].tvcartextduration2
            }
        }

        override fun getItemCount(): Int {
            return cars.size
        }


}