package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityMovieDetailBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyLists
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShowsModel
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
    var idFound: Int? = 0
    var flagReview = 0

    var user_review : String? = ""
    var user_score: String ?= ""
    var list_watched_type: String ?= ""

    val spinnerScores = arrayOf(" Select Score","(1) Appalling ", "(2) Horrible", "(3) Very Bad",
        "(4) Bad", "(5) Average", "(6) Fine", "(7) Good", "(8) Very Good", "(9) Great", "(10) Masterpiece")

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

        //Set up spinnerScore
        val spinnerScoreAdapter = ArrayAdapter(this, R.layout.custom_selected_item, spinnerScores)
        spinnerScoreAdapter.setDropDownViewResource(R.layout.custom_dropdown_item)
        binding.spinnerScore.adapter = spinnerScoreAdapter

        getData()
        setListener()
    }

    @SuppressLint("SuspiciousIndentation")
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
        user_review = intent.getStringExtra("user_review")
        user_score = intent.getStringExtra("user_score")
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
                if(it != null)
                    tvShow = it as TvShows
            })

            tvShowsModel.getUserScore(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_score = it as String
                else
                    user_score = " Select Score"

                val indexOfUserScore = spinnerScores.indexOf(user_score)
                binding.spinnerScore.setSelection(indexOfUserScore)
            })

            tvShowsModel.getUserReview(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_review = it as String
                else
                    user_review = ""
                if(flagReview == 0)
                    binding.editReview.setText(user_review)
                flagReview = 1
            })

        }
        else if (showType.equals("movie")){
            moviesModel.getMovie(this, id!!).observe(this, Observer {
                if(it != null)
                    movie = it as Movies
            })

            moviesModel.getUserScore(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_score = it as String
                else
                    user_score = " Select Score"

                val indexOfUserScore = spinnerScores.indexOf(user_score)
                binding.spinnerScore.setSelection(indexOfUserScore)
            })

            moviesModel.getUserReview(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_review = it as String
                else
                    user_review = ""
                if(flagReview == 0)
                    binding.editReview.setText(user_review)
                flagReview = 1
            })

        }

        else if (showType.equals("list")) {
            myListViewModel.getUserScore(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_score = it as String
                else
                    user_score = " Select Score"

                val indexOfUserScore = spinnerScores.indexOf(user_score)
                binding.spinnerScore.setSelection(indexOfUserScore)
            })

            myListViewModel.getUserReview(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_review = it as String
                else
                    user_review = ""
                if(flagReview == 0)
                    binding.editReview.setText(user_review)
                flagReview = 1
            })

            myListViewModel.getMovieId(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                idFound = it.toString().toInt()
            })

            myListViewModel.getTvShowId(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                idFound = it.toString().toInt()
            })

            myListViewModel.getType(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                list_watched_type = it.toString()
            })
        }

        else if (showType.equals("watched")) {
            watchListviewModel.getUserScore(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_score = it as String
                else
                    user_score = " Select Score"

                val indexOfUserScore = spinnerScores.indexOf(user_score)
                binding.spinnerScore.setSelection(indexOfUserScore)
            })

            watchListviewModel.getUserReview(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    user_review = it as String
                else
                    user_review = ""
                if(flagReview == 0)
                    binding.editReview.setText(user_review)
                flagReview = 1
            })

            watchListviewModel.getMovieId(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    idFound = it.toString().toInt()
            })

            watchListviewModel.getTvShowId(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                    idFound = it.toString().toInt()
            })

            watchListviewModel.getType(this, id!!).observe(this, Observer {
                if (!it.isNullOrBlank())
                list_watched_type = it.toString()
            })
        }
    }

    fun setListener(){
        binding.llMyList.setOnClickListener {
            if(showType.equals("tvshow") && isInMyList.equals("No")){
                tvShowsModel.updateIsInMylist(this,"Yes",id!!)
                isInMyList = "Yes"
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
                        user_review = user_review.toString()!!,
                        user_score = user_score.toString()!!,
                        tvShowId = id.toString(),
                        movieId = "",
                        type = "tvshow"
                    )
                )
                Log.d("TEST",  isInMyList.toString() + isWatched.toString())
            }
            else if((showType.equals("tvshow") || showType.equals("list") || showType.equals("watched")) && isInMyList.equals("Yes")){
                tvShowsModel.updateIsInMylist(this,"No",idFound!!)
                moviesModel.updateIsInMylist(this,"No",name!!)
                isInMyList = "No"
                binding.imgMylist.setImageResource(R.drawable.ic_add)
                myListViewModel.deleteMyList(name!!)
            }

            if(showType.equals("movie") && isInMyList.equals("No")){
                moviesModel.updateIsInMylist(this,"Yes",name!!)
                isInMyList = "Yes"
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
                        user_review = user_review!!,
                        user_score = user_score!!,
                        movieId = id.toString()!!,
                        tvShowId = "",
                        type = "movie"
                    )
                )

            }
            else if((showType.equals("movie") || showType.equals("list") || showType.equals("watched")) && isInMyList.equals("Yes")){
                myListViewModel.deleteMyList(name!!)
                moviesModel.updateIsInMylist(this,"No",name!!)
                tvShowsModel.updateIsInMylist(this,"No",idFound!!)
                isInMyList = "No"
                binding.imgMylist.setImageResource(R.drawable.ic_add)
            }
    }

        binding.llWatched.setOnClickListener {

            if(showType.equals("tvshow") && isWatched.equals("No")){
                tvShowsModel.updateIsWatched(this,"Yes",id!!)
                isWatched = "Yes"
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
                        user_review = user_review!!,
                        user_score = user_score!!,
                        tvShowId = id.toString(),
                        movieId = "",
                        type = "tvshow"
                    )
                )
                Log.d("TEST",  isInMyList.toString() + isWatched.toString())
            }
            else if((showType.equals("tvshow") || showType.equals("watched") || showType.equals("list")) && isWatched.equals("Yes")){
                tvShowsModel.updateIsWatched(this,"No",idFound!!)
                moviesModel.updateIsWatched(this, "No", idFound!!)
                isWatched = "No"
                binding.imgWatched.setImageResource(R.drawable.ic_add)
                watchListviewModel.deleteWatched(name!!)
            }

             if(showType.equals("movie") && isWatched.equals("No")){
                 moviesModel.updateIsWatched(this,"Yes",id!!)
                 isWatched = "Yes"
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
                         user_review = user_review!!,
                         user_score = user_score!!,
                         movieId = id.toString()!!,
                         tvShowId = "",
                         type = "movie"
                     )
                 )
             }
             else if((showType.equals("movie") || showType.equals("watched") || showType.equals("list")) && isWatched.equals("Yes")){
                 moviesModel.updateIsWatched(this,"No",idFound!!)
                 tvShowsModel.updateIsWatched(this, "No", idFound!!)
                 isWatched = "No"
                 binding.imgWatched.setImageResource(R.drawable.ic_add)
                 watchListviewModel.deleteWatched(name!!)
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
                intent.putExtra("idFound", idFound)
                intent.putExtra("showType",showType)
                intent.putExtra("type", list_watched_type)
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


        //Get user score from spinner
        val movieId = id
        binding.spinnerScore.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = spinnerScores[position]
                if(showType.equals("movie"))
                    moviesModel.updateUserScore(this@MovieDetailActivity, selectedItem, movieId!!)
                else if(showType.equals("tvshow")) {
                    tvShowsModel.updateUserScore(this@MovieDetailActivity, selectedItem, movieId!!)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //Get user review from edit text
        binding.editReview.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(showType.equals("movie"))
                        moviesModel.updateUserReview(this@MovieDetailActivity, binding.editReview.text.toString(), movieId!!)
                    else if(showType.equals("tvshow"))
                        tvShowsModel.updateUserReview(this@MovieDetailActivity, binding.editReview.text.toString(), movieId!!)
                }
        })

    }
}