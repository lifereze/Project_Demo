package com.example.project_demo.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project_demo.LoginActivity
import com.example.project_demo.MainActivity
import com.example.project_demo.R
import com.example.project_demo.ViewModels.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    lateinit var  firebaseAuth: FirebaseAuth

    lateinit var loginViemodel:LoginViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        loginViemodel = activity?.let { ViewModelProvider(it).get(LoginViewModel::class.java) }!!

        btnlogin.setOnClickListener{
            loginUser()

        }

        loginViemodel.mLiveDataCode.observe(viewLifecycleOwner, {
            if(it == 201){
                Toast.makeText(context, "apilogin success", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loginUser() {
        val email:String
        val password:String
        if(etEmail.text.toString().trim() != "" && etpassword.text.toString().trim() != "" ){
            email = etEmail.text.toString().trim()
            password = etpassword.text.toString().trim()
            context?.let { loginViemodel.loginUser(it,email,password) }
            createUser(email, password)
        }else{
            Toast.makeText(context, "Invalid Inputs", Toast.LENGTH_SHORT).show()
        }

    }
    private fun createUser(email:String, password:String){

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                moveToMainActivity()
                LoginActivity().finish()
            }
            .addOnFailureListener{
                Toast.makeText(context, "SignUp Failed", Toast.LENGTH_LONG).show()
            }

    }

    fun moveToMainActivity(){
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent);
    }
}