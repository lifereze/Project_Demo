package com.example.project_demo.ViewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project_demo.MainActivity
import com.example.project_demo.Models.LoginResponse
import com.example.project_demo.Network.APIService
import com.example.project_demo.Network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel:ViewModel() {

    private val TAG = "LoginViewModel"

    lateinit var mApiService: APIService
    lateinit var mCall: Call<LoginResponse>
    var mUserMutableLiveData: MutableLiveData<String>? = MutableLiveData()
    var mLiveData: MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()
    var mLiveDataCode: MutableLiveData<Int> = MutableLiveData<Int>()

    fun loginUser(context: Context, email: String, password: String) {
        mApiService = RetrofitInstance.getRetroClient()?.create(APIService::class.java)!!
        mCall = mApiService?.loginUser(email,password)!!;
        mCall!!.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.code() == 201) { //@TODO check verification code failing when 200
                    //Save user to local storage
                    if (response.body() != null) {
                        mLiveData.postValue(response.body())
                      mLiveDataCode.postValue(response.code())
                    } else {

                        mLiveDataCode.value = response.code()
                        Toast.makeText(context, "Wrong password", Toast.LENGTH_LONG).show()
                    }
                } else {
                    mLiveDataCode.value = response.code()

                    Toast.makeText(context, "Wrong password", Toast.LENGTH_LONG).show()
                    Toast.makeText(context, response.code().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Log.w(TAG, "onFailure: " + t.message)
                println(call)
                mUserMutableLiveData = null
            }
        })
    }


}