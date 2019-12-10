package com.gosigitgo.thirdcodelabmovie

import android.content.Context
import com.gosigitgo.thirdcodelabmovie.base.BasePresenter

//implement member
class DetailMoviePresenter (var context: Context) :BasePresenter<DetailMovieView> {
    var detailMovieView : DetailMovieView? = null
    //berhasil ditampilkan
    override fun onAttach(view: DetailMovieView) {
        detailMovieView = view
    }
    //tidak berhasil ditampilkan
    override fun onDettach() {
        detailMovieView = null
    }
}