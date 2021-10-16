package com.example.project_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_demo.Fragments.CarsFragment
import kotlinx.android.synthetic.main.activity_cars.*

class CarsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        setFragment()
    }

    fun setFragment(){
        val fragment = CarsFragment();
        supportFragmentManager.beginTransaction().apply {
            this.add(R.id.flcars, fragment)
            .commit()
        }
    }
}