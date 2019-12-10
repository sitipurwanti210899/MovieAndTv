package com.gosigitgo.thirdcodelabmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gosigitgo.thirdcodelabmovie.BuildConfig
import com.gosigitgo.thirdcodelabmovie.R
import com.gosigitgo.thirdcodelabmovie.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_row.view.*


class TvAdapter (
    private val tvData: List<ResultsItem?>?,
    private val context : Context?) : RecyclerView.Adapter<TvAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = tvData?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvData?.get(position)!!)
    }

    class ViewHolder (override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bind (tvData: ResultsItem){
            itemView.tv_title.text = tvData.originalName
            itemView.tv_overview.text = tvData.overview
            itemView.tv_date.text = tvData.firstAirDates

            //menampilkan data gambar
            Picasso.get().load(BuildConfig.POSTER_URL + tvData.posterPath)
                .resize(150,150).centerCrop().into(itemView.iv_poster)


        }

    }

}