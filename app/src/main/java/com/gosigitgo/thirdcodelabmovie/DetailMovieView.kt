package com.gosigitgo.thirdcodelabmovie

import android.os.Message
import com.gosigitgo.thirdcodelabmovie.base.BaseView
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem

interface DetailMovieView : BaseView {
    //buat fun display detail movie
    fun displayDetailMovie (item : List<ResultsItem>)
    fun error (message: String?)
}