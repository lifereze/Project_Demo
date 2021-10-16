package com.example.project_demo.Network

import com.example.project_demo.Models.LoginResponse
import com.example.project_demo.Models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @FormUrlEncoded
    @POST("users")
    fun loginUser(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<LoginResponse>?

    @GET("users/2")
    fun getUser(
    ): Call<UserResponse>?
}