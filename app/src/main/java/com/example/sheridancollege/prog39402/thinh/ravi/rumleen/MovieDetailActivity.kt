package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.R.id
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityMovieDetailBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyLists
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShowsModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchList
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchListviewModel


class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    var image : String? = ""
    var name : String? = ""
    var rating : String? = ""
    var time : String? = ""
    var trailor : String? = ""
    var isWatched : String? = ""
    var director_name : String? = ""
    var director_image : String? = ""
    var description : String? = ""
    var showType : String? = ""
    var isInMyList : String? = ""
    var isChildren : String? = ""
    var id : Int? = 0

    private lateinit var myListViewModel: MyListViewModel
    private lateinit var watchListviewModel: WatchListviewModel
    private lateinit var tvShowsModel: TvShowsModel
    private lateinit var moviesModel: MoviesViewModel

    var tvShow : TvShows? = null
    var movie : Movies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myListViewModel = ViewModelProvider(this).get(MyListViewModel::class.java)
        watchListviewModel = ViewModelProvider(this).get(WatchListviewModel::class.java)
        tvShowsModel = ViewModelProvider(this).get(TvShowsModel::class.java)
        moviesModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        getData()
        setListener()
    }

    fun getData(){
        image = intent.getStringExtra("image")
        isInMyList = intent.getStringExtra("isInMyList")
        name = intent.getStringExtra("name")
        rating = intent.getStringExtra("rating")
        isChildren = intent.getStringExtra("isChildren")
        time = intent.getStringExtra("time")
        trailor = intent.getStringExtra("trailor")
        isWatched = intent.getStringExtra("isWatched")
        showType = intent.getStringExtra("showType")
        id = intent.getIntExtra("id",0)
        director_name = intent.getStringExtra("director_name")
        director_image = intent.getStringExtra("director_image")
        description = intent.getStringExtra("description")
        binding.txtRating.setText(rating)
        binding.txtTotalTime.setText(time)
        binding.txtMoviName.setText(name)

        if(isInMyList.equals("Yes")){
            binding.imgMylist.setImageResource(R.drawable.ic_done)
        }
        else{
            binding.imgMylist.setImageResource(R.drawable.ic_add)
        }
        if(isWatched.equals("Yes")){
            binding.imgWatched.setImageResource(R.drawable.ic_done)
        }
        else{
            binding.imgWatched.setImageResource(R.drawable.ic_add)
        }
        Glide
            .with(applicationContext)
            .load(image)
            .into(binding.imgMovie);

        if(showType.equals("tvshow")){
            tvShowsModel.getMovie(this, id!!).observe(this, Observer {
                 tvShow = it as TvShows
            })
        }
        else{
            moviesModel.getMovie(this, id!!).observe(this, Observer {
                movie = it as Movies
            })
        }
    }

    fun setListener(){
        binding.llMyList.setOnClickListener {
            if(showType.equals("tvshow")){
                if(isInMyList.equals("No")){
                    tvShowsModel.updateIsInMylist(this,"Yes",id!!)
                    binding.imgMylist.setImageResource(R.drawable.ic_done)
                    myListViewModel.insert(applicationContext,
                        MyLists(name =name!!,
                            image = image!!,
                            isChildren = isChildren!!,
                            director_image = director_image!!,
                            director_name = director_name!!,
                            trailor_link = trailor!!,
                            total_time = time!!,
                            casts = tvShow!!.casts,
                            rating = rating!!,
                            isWatched = isWatched!!,
                            isInMyList = "Yes",
                        )
                    )
                }
                else{
                    tvShowsModel.updateIsInMylist(this,"No",id!!)
                    binding.imgMylist.setImageResource(R.drawable.ic_add)
                    myListViewModel.deleteMyList(name!!)
                }
            }
            else if(showType.equals("movie")){
                if(isInMyList.equals("No")){
                    moviesModel.updateIsInMylist(this,"Yes",name!!)
                    binding.imgMylist.setImageResource(R.drawable.ic_done)
                    myListViewModel.insert(applicationContext,
                        MyLists(name =name!!,
                            image = image!!,
                            isChildren = isChildren!!,
                            director_image = director_image!!,
                            director_name = director_name!!,
                            trailor_link = trailor!!,
                            total_time = time!!,
                            casts = movie!!.casts,
                            rating = rating!!,
                            isWatched = isWatched!!,
                            isInMyList = "Yes",
                        )
                    )
                }
                else{
                    myListViewModel.deleteMyList(name!!)
                    moviesModel.updateIsInMylist(this,"No",name!!)
                    binding.imgMylist.setImageResource(R.drawable.ic_add)
                }

            }
        }
        binding.llWatched.setOnClickListener {

            if(showType.equals("tvshow")){
                if(isWatched.equals("No")){
                    tvShowsModel.updateIsWatched(this,"Yes",id!!)
                    binding.imgWatched.setImageResource(R.drawable.ic_done)
                    watchListviewModel.insert(applicationContext,
                        WatchList(name =name!!,
                            image = image!!,
                            isChildren = isChildren!!,
                            director_image = director_image!!,
                            director_name = director_name!!,
                            trailor_link = trailor!!,
                            total_time = time!!,
                            casts = tvShow!!.casts,
                            rating = rating!!,
                            isWatched = "Yes",
                            isInMyList = isInMyList!!,
                        )
                    )
                }
                else{
                    tvShowsModel.updateIsWatched(this,"No",id!!)
                    binding.imgWatched.setImageResource(R.drawable.ic_add)
                    watchListviewModel.deleteWatched(name!!)
                }

            }
            else if(showType.equals("movie")){
                if(isWatched.equals("No")){
                    moviesModel.updateIsWatched(this,"Yes",id!!)
                    binding.imgWatched.setImageResource(R.drawable.ic_done)
                    watchListviewModel.insert(applicationContext,
                        WatchList(name =name!!,
                            image = image!!,
                            isChildren = isChildren!!,
                            director_image = director_image!!,
                            director_name = director_name!!,
                            trailor_link = trailor!!,
                            total_time = time!!,
                            casts = movie!!.casts,
                            rating = rating!!,
                            isWatched = "Yes",
                            isInMyList = isInMyList!!,
                        )
                    )
                }
                else{
                    moviesModel.updateIsWatched(this,"No",id!!)
                    binding.imgWatched.setImageResource(R.drawable.ic_add)
                    watchListviewModel.deleteWatched(name!!)
                }

            }
        }

        binding.llTrailor.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(trailor)
            intent.setPackage("com.google.android.youtube")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                intent.data = Uri.parse(trailor)
                startActivity(intent)
            }
        }
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.imgHome.setOnClickListener {
            finish()
        }
        binding.imgMore.setOnClickListener {
            val customDialog = Dialog(this)
            customDialog.setContentView(R.layout.dialog_more)
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(customDialog.window?.attributes)
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            customDialog.window?.attributes = layoutParams
            val btnCast = customDialog.findViewById<AppCompatButton>(R.id.btnCast)
            val btnDirector = customDialog.findViewById<AppCompatButton>(R.id.btnDirector)
            val btnDescription = customDialog.findViewById<AppCompatButton>(R.id.btnDescription)
            val btnCancel = customDialog.findViewById<AppCompatButton>(R.id.btnCancel)

            btnCast.setOnClickListener {
                val intent = Intent(applicationContext, CastActivity::class.java)
                intent.putExtra("id",id)
                intent.putExtra("showType",showType)
                startActivity(intent)
            }

            btnDirector.setOnClickListener {
                val intent = Intent(applicationContext, DirectorActivity::class.java)
                intent.putExtra("director_name",director_name)
                intent.putExtra("director_image",director_image)
                startActivity(intent)
            }

            btnDescription.setOnClickListener {
                val intent = Intent(applicationContext, DescriptionActivity::class.java)
                intent.putExtra("description",description)
                startActivity(intent)
            }

            btnCancel.setOnClickListener {
                customDialog.dismiss()
                finish()
            }
            customDialog.show()
        }

        binding.imgShare.setOnClickListener{
            Toast.makeText(this, "$name, $rating", Toast.LENGTH_SHORT).show();

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Checkout my new Binge List Rating:\nTitle:$name\nMy Rating:$rating\nDownload Binge List now to create your own rating!")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}