package com.gosigitgo.thirdcodelabmovie.pattern

import com.gosigitgo.thirdcodelabmovie.base.BaseView
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem

//extend ke baseview memakai :, kalau koma untuk extend ke class
interface MovieView : BaseView{
    //jika berhasil
    fun showDataMovie (item : List<ResultsItem>) // biar jadi global, diambil dari model
   //jika gagal
    fun error (message: String?) // ? dikosongkan
}