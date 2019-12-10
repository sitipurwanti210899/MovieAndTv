package com.gosigitgo.thirdcodelabmovie.base

//extend ke View dan data
interface BasePresenter <in T: BaseView> {
    //jika berhasil
    fun onAttach(view: T)
    //jika gagal
    fun onDettach()
}