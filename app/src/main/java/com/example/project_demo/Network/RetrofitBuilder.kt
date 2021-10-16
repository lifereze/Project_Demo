package com.example.project_demo.Network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.smarteist.autoimageslider.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.lang.RuntimeException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class RetrofitBuilder {
    //https://reqres.in/api/users?page

    //https://reqres.in/api/users?page =2
}
object RetrofitInstance {
    var BASE_URL = "https://reqres.in/api/"
    private var sRetrofit: Retrofit? = null
    private var sHttpLoggingInterceptor: HttpLoggingInterceptor? = null
    private var sOkHttpClient: OkHttpClient? = null

    fun getRetroClient(): Retrofit? {
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(

                OkHttpClient.Builder().also { client ->
                    if(BuildConfig.DEBUG){
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)}

                }.build()

            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}