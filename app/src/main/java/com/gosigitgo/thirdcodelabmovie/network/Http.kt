package com.gosigitgo.thirdcodelabmovie.network

import com.gosigitgo.thirdcodelabmovie.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Http {
    val instance : Retrofit by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        //service untuk mengirim request
        //memakai var karena request dari server bisa berubah"
        var okHttp = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) //batas pengiriman request
            .writeTimeout(30, TimeUnit.SECONDS) //ketika kita mengirim request dengan batasanw aktu
            .retryOnConnectionFailure(true) //tidak ada respon kemudian di set lagi
            .build()
        Retrofit.Builder().baseUrl(BuildConfig.API_URL) //manggil di gradle modul
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create()).build()//convert ke GSON tadi
    }
    val retrofit : ServiceClient
    get() = instance.create(ServiceClient::class.java)

}