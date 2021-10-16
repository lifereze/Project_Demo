package com.example.project_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.project_demo.Fragments.SignUpFragment
import com.example.project_demo.Fragments.SplashLoginFragment
import com.example.project_demo.ViewModels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var loginViemodel:LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setFragment()

        }
    fun setFragment() {
        val fragment = SplashLoginFragment()
        supportFragmentManager?.beginTransaction()?.apply {
            this.add(R.id.fllogin, fragment)
                .commit()
        }
    }

}