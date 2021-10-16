package com.example.project_demo.ViewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project_demo.MainActivity
import com.example.project_demo.Models.LoginResponse
import com.example.project_demo.Models.UserResponse
import com.example.project_demo.Network.APIService
import com.example.project_demo.Network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel:ViewModel() {
    private val TAG = "MainActVM"

    lateinit var mApiService: APIService
    lateinit var mCall: Call<UserResponse>
    var mUserMutableLiveData: MutableLiveData<String>? = MutableLiveData()
    var mLiveData: MutableLiveData<UserResponse> = MutableLiveData<UserResponse>()
    var mLiveDataCode: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getUserProfile(context: Context) {
        mApiService = RetrofitInstance.getRetroClient()?.create(APIService::class.java)!!
        mCall = mApiService?.getUser()!!;
        mCall!!.enqueue(object : Callback<UserResponse?> {
            override fun onResponse(
                call: Call<UserResponse?>,
                response: Response<UserResponse?>
            ) {
                if (response.code() >= 200 && response.code() <300) { //@TODO check verification code failing when 200
                    //Save user to local storage
                    if (response.body() != null) {
                        mLiveData.postValue(response.body())
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

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                Log.w(TAG, "onFailure: " + t.message)
                println(call)
                mUserMutableLiveData = null
            }
        })
    }

}