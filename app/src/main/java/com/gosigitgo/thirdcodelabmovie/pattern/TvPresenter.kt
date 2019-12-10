package com.gosigitgo.thirdcodelabmovie.pattern

import com.gosigitgo.thirdcodelabmovie.base.BasePresenter
import com.gosigitgo.thirdcodelabmovie.model.ResponseMovie
import com.gosigitgo.thirdcodelabmovie.network.Http
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TvPresenter (var tvView: TvView? = null) : BasePresenter<TvView> {

    fun getTvPopularTv (api_key : String, language : String){
        Http.retrofit.getTvPopular(api_key, language)
            .enqueue(object : Callback<ResponseMovie>{
                override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {
                  tvView?.error(t.message)
                }
                override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                    tvView?.showDataTv(response.body()?.results!!)
                }
            })
    }
    override fun onAttach(view: TvView) {
        tvView = view
    }

    override fun onDettach() {
        tvView = null
    }
}