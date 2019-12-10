package com.gosigitgo.thirdcodelabmovie.pattern

import com.gosigitgo.thirdcodelabmovie.base.BasePresenter
import com.gosigitgo.thirdcodelabmovie.model.ResponseMovie
import com.gosigitgo.thirdcodelabmovie.network.Http
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//implemen members
//karena base view sudah dipanggil di basepresenter jadi diringkas
class MoviePresenter(var movieView: MovieView? = null) : BasePresenter<MovieView> {
    //get data dari server(service client)
    fun getUpComingMovies (api_key : String, language : String){
        Http.retrofit.getUpComing(api_key, language)
                //object di implements members
            .enqueue(object : Callback<ResponseMovie>{
                //error
                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                movieView?.error(t.message)
                }
                //berhasil
                override fun onResponse(
                    call: Call<ResponseMovie>,
                    response: Response<ResponseMovie>
                ) {
                    movieView?.showDataMovie(response.body()?.results!!)
                }
            })
    }
    //ketika berhasil
    override fun onAttach(view: MovieView) {
        movieView = view
    }
    //ketika gagal
    override fun onDettach() {
        movieView = null
    }
}
//1. buat view
//2. get data
//3. panggil responsnya