package com.gosigitgo.thirdcodelabmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gosigitgo.thirdcodelabmovie.BuildConfig
import com.gosigitgo.thirdcodelabmovie.DetailActivity
import com.gosigitgo.thirdcodelabmovie.R
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_row.view.*
import org.jetbrains.anko.startActivity

//implement members
class MovieAdapter (
private val movieData: List<ResultsItem?>?,
private val context : Context?) : RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{
    //nempelin layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }
    //menghitung data yang akan ditampilkan
    override fun getItemCount(): Int = movieData?.size!!
    //nge set dan nge get
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(movieData?.get(position)!!)

    }
    //create class
    class ViewHolder(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!), LayoutContainer{
        fun bind (movieData: ResultsItem){
            itemView.tv_title.text = movieData.originalTitle
            itemView.tv_overview.text = movieData.overview
            itemView.tv_date.text = movieData.releaseDate

            //menampilkan data gambar
            Picasso.get().load(BuildConfig.POSTER_URL + movieData.posterPath)
                .resize(150,150).centerCrop().into(itemView.iv_poster)


            //kirim data detail
            containerView?.setOnClickListener {
                it.context.startActivity<DetailActivity> (
                    DetailActivity.ID to movieData.id.toString(),
                    DetailActivity.TITLE to movieData.originalTitle!!,
                    DetailActivity.DATE to movieData.releaseDate!!,
                    DetailActivity.OVERVIEW to movieData.overview!!,
                    DetailActivity.IMAGES to movieData.posterPath!!
                )
            }


        }
    }
}