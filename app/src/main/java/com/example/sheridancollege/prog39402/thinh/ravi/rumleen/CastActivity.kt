package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter.CastAdapter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityCastBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityDirectorBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityMovieDetailBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShowsModel

class CastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCastBinding
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var tvShowsModel: TvShowsModel
    private lateinit var castsAdapter: CastAdapter
    var showType : String? = null

    var id : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        setListener()
    }

    fun getData(){
        castsAdapter = CastAdapter(this, emptyList())
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        tvShowsModel = ViewModelProvider(this).get(TvShowsModel::class.java)
        id = intent.getIntExtra("id",0)
        showType = intent.getStringExtra("showType")

        binding.rvCast.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(applicationContext)
            adapter = castsAdapter
        }

        if(showType.equals("movie")){
            moviesViewModel.getMovie(this, id!!).observe(this, Observer {
                var movie = it as Movies
                castsAdapter.setData(movie.casts as ArrayList<Cast>)
            })
        }
        else{
            tvShowsModel.getMovie(this, id!!).observe(this, Observer {
                var tvShow = it as TvShows
                castsAdapter.setData(tvShow.casts as ArrayList<Cast>)
            })
        }

    }

    fun setListener(){
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.imgHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}