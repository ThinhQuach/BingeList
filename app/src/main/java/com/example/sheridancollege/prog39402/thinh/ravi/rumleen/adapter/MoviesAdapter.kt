package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.MovieDetailActivity
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.R
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.SignUpActivity
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies

class MoviesAdapter(context:Activity,private var movies: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    lateinit var context1 : Activity

    init {
        context1 = context
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMovie: AppCompatImageView = itemView.findViewById(R.id.imgMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    fun setData(userList:ArrayList<Movies>)
    {
        this.movies=userList
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = movies[position]
        Glide
            .with(context1)
            .load(movies.image)
            .into(holder.imgMovie);
        holder.itemView.setOnClickListener {
            val intent = Intent(context1, MovieDetailActivity::class.java)
            intent.putExtra("image",movies.image)
            intent.putExtra("id",movies.id)
            intent.putExtra("isChildren",movies.isChildren)
            intent.putExtra("isInMyList",movies.isInMyList)
            intent.putExtra("description",movies.description)
            intent.putExtra("showType","movie")
            intent.putExtra("name",movies.name)
            intent.putExtra("rating",movies.rating)
            intent.putExtra("time",movies.total_time)
            intent.putExtra("trailor",movies.trailor_link)
            intent.putExtra("isWatched",movies.isWatched)
            intent.putExtra("isMyList",movies.isInMyList)
            intent.putExtra("director_name",movies.director_name)
            intent.putExtra("director_image",movies.director_image)
            context1.startActivity(intent)
        }

    }
    override fun getItemCount(): Int = movies.size
}
