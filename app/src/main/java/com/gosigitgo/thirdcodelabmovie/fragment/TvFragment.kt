package com.gosigitgo.thirdcodelabmovie.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gosigitgo.thirdcodelabmovie.BuildConfig
import com.gosigitgo.thirdcodelabmovie.R
import com.gosigitgo.thirdcodelabmovie.adapter.TvAdapter
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem
import com.gosigitgo.thirdcodelabmovie.pattern.TvPresenter
import com.gosigitgo.thirdcodelabmovie.pattern.TvView
import kotlinx.android.synthetic.main.fragment_tv.*
import org.jetbrains.anko.toast

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment(), TvView {

    private lateinit var presenter: TvPresenter
    private var tvList: MutableList<ResultsItem?>? = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = TvPresenter()
        presenter.getTvPopularTv(
            BuildConfig.API_KEY,
            BuildConfig.LANGUAGE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }
    override fun showDataTv(item: List<ResultsItem>) {
        tvList?.clear()
        tvList?.addAll(item)
        val LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_tv.layoutManager = LayoutManager
        rv_tv.adapter = TvAdapter(tvList, context)

    }

    override fun error(massage: String?) {
        context?.toast(massage!!)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        presenter.onDettach()
    }
    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDettachView()
    }

}
