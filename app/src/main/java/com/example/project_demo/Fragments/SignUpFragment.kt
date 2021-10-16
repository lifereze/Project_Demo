package com.example.project_demo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.project_demo.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.etEmail
import kotlinx.android.synthetic.main.fragment_sign_in.etpassword
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.*


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    lateinit var  firebaseAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        btnSignup.setOnClickListener{
                getUserInput()
        }

    }

     fun getUserInput(){
            val email:String
            val password:String
            if(etEmail.text.toString().trim() != "" && etpassword.text.toString().trim() != "" && etconfirmpassword.text.toString().trim() != "" ){
               if(etpassword.text.toString().trim().equals(etconfirmpassword.text.toString().trim())){
                   email = etEmail.text.toString().trim()
                   password = etpassword.text.toString().trim()
                   lifecycleScope.launch{
                       createUser(email,password)
                   }

               }else{
                   Toast.makeText(context, "Passwords Do Not Match", Toast.LENGTH_SHORT).show()
               }

            }else{
                Toast.makeText(context, "Invalid Inputs", Toast.LENGTH_SHORT).show()
            }

    }

    private fun createUser(email:String, password:String) {

       firebaseAuth.createUserWithEmailAndPassword(email, password)
           .addOnSuccessListener {
                   setFragment()
           }
           .addOnFailureListener{
               Toast.makeText(context, "SignUp Failed", Toast.LENGTH_LONG).show()
           }

    }

    fun setFragment() {
        val fragment = SignInFragment();
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            this.replace(R.id.fllogin, fragment)
                .commit()
        }
    }

}