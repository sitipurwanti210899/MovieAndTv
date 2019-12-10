package com.gosigitgo.thirdcodelabmovie.pattern

import com.gosigitgo.thirdcodelabmovie.base.BaseView
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem

interface TvView : BaseView {
    fun showDataTv (item: List<ResultsItem>)
    fun error (massage : String?)
}