package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.MovieDetailActivity
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.R
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows

class TvShowsAdapter(context:Activity, private var tvShows: List<TvShows>) :
    RecyclerView.Adapter<TvShowsAdapter.ViewHolder>() {
    lateinit var context1 : Activity

    init {
        context1 = context
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgTVShow: AppCompatImageView = itemView.findViewById(R.id.imgTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tvshows, parent, false)
        return ViewHolder(view)
    }

    fun setData(tvShows1:ArrayList<TvShows>)
    {
        this.tvShows = tvShows1
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShows = tvShows[position]
        Glide
            .with(context1)
            .load(tvShows.image)
            .into(holder.imgTVShow);
        holder.itemView.setOnClickListener {
            val intent = Intent(context1, MovieDetailActivity::class.java)
            intent.putExtra("image",tvShows.image)
            intent.putExtra("id",tvShows.id)
            intent.putExtra("isChildren",tvShows.isChildren)
            intent.putExtra("isInMyList",tvShows.isInMyList)
            intent.putExtra("description",tvShows.description)
            intent.putExtra("showType","tvshow")
            intent.putExtra("name",tvShows.name)
            intent.putExtra("rating",tvShows.rating)
            intent.putExtra("time",tvShows.total_time)
            intent.putExtra("trailor",tvShows.trailor_link)
            intent.putExtra("isWatched",tvShows.isWatched)
            intent.putExtra("isMyList",tvShows.isInMyList)
            intent.putExtra("director_name",tvShows.director_name)
            intent.putExtra("director_image",tvShows.director_image)
            context1.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = tvShows.size
}
