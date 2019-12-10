package com.gosigitgo.thirdcodelabmovie.network

import com.gosigitgo.thirdcodelabmovie.model.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceClient {
    //nge-read data pakai get movie
    @GET ("movie/upcoming") //end point dari moviedb
    //nambahin api_key dan language sesuai dengan moviedb
    fun getUpComing(
        @Query ("api_key") api_key : String,
        @Query ("language") language : String
    ): Call<ResponseMovie>

    //tvshow
    @GET ("tv/popular")
    fun getTvPopular(
        @Query ("api_key") api_key: String,
        @Query ("language") language: String
    ): Call<ResponseMovie>
}