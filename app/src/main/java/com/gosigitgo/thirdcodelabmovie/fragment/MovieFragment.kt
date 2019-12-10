package com.gosigitgo.thirdcodelabmovie.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gosigitgo.thirdcodelabmovie.BuildConfig
import com.gosigitgo.thirdcodelabmovie.R
import com.gosigitgo.thirdcodelabmovie.adapter.MovieAdapter
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem
import com.gosigitgo.thirdcodelabmovie.pattern.MoviePresenter
import com.gosigitgo.thirdcodelabmovie.pattern.MovieView
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.toast

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), MovieView {
    private lateinit var presenter: MoviePresenter
    private var movieList: MutableList<ResultsItem?>? = mutableListOf()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }
    //membuat activity
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = MoviePresenter()
        presenter.getUpComingMovies(
            BuildConfig.API_KEY,
            BuildConfig.LANGUAGE
        )
    }

    override fun showDataMovie(item: List<ResultsItem>) {
        movieList?.clear()
        movieList?.addAll(item)
        val LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_movie.layoutManager = LayoutManager
        rv_movie.adapter = MovieAdapter(movieList, context)
    }

    override fun error(message: String?) {
        context?.toast(message!!)
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
