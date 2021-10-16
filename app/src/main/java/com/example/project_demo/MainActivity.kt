package com.example.project_demo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project_demo.ViewModels.MainActivityViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.userAgent

class MainActivity : AppCompatActivity() {
    lateinit var  mainActViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        (mainActViewModel as MainActivityViewModel).getUserProfile(this);
        (mainActViewModel as MainActivityViewModel).mLiveData.observe(this,{user ->
            Picasso
                .get()
                .load(user.data.avatar)
                .into(ivprofile);
    })

        ivsecondArrow.setOnClickListener{
            val intent = Intent(this, CarsActivity::class.java)
            startActivity(intent)
        }
    }
}