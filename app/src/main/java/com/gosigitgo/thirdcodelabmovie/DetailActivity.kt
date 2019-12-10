package com.gosigitgo.thirdcodelabmovie


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

//implement member
class DetailActivity : AppCompatActivity(), DetailMovieView {

    companion object{
        const val ID : String ="ID"
        const val TITLE : String ="TITLE"
        const val DATE : String ="DATE"
        const val OVERVIEW : String ="OVERVIEW"
        const val IMAGES : String ="IMAGES"
    }
    //inisialisasi si object menjadi variabel
    lateinit var presenter: DetailMoviePresenter
    lateinit var id : String
    lateinit var title: String
    lateinit var date : String
    lateinit var overview : String
    lateinit var images : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //result presenter ke context
        presenter = DetailMoviePresenter(this)
        id = intent.getStringExtra(ID)
        title = intent.getStringExtra(TITLE)
        date = intent.getStringExtra(DATE)
        overview = intent.getStringExtra(OVERVIEW)
        images = intent.getStringExtra(IMAGES)
        tv_title_detail.text = title
        tv_date_detail.text = date
        tv_overview_detail.text = overview

        Picasso.get().load(BuildConfig.POSTER_URL + images)
            .resize(120, 160)
            .centerCrop()
            .into(iv_detail)
    }
    override fun displayDetailMovie(item: List<ResultsItem>) {
    }

    override fun error(message: String?) {
        toast(message!!)
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
