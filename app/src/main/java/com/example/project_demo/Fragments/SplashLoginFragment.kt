package com.example.project_demo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_demo.R
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SplashLoginFragment : Fragment(R.layout.fragment_splash_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignup.setOnClickListener{
            val fragment = SignUpFragment();
            setFragment(fragment)
        }
        btnlogin.setOnClickListener{
            val fragment = SignInFragment();
            setFragment(fragment)
        }
    }

    fun setFragment(fragment:Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            this.replace(R.id.fllogin, fragment)
                .commit()
        }
    }
}