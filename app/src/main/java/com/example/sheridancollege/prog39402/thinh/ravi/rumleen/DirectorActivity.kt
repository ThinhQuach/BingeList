package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityDirectorBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityMovieDetailBinding

class DirectorActivity : AppCompatActivity() {
    var director_name : String? = ""
    var director_image : String? = ""
    private lateinit var binding: ActivityDirectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDirectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getsetData()
        setListener()
    }

    fun setListener(){
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.imgHome.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getsetData(){
        director_name = intent.getStringExtra("director_name")
        director_image = intent.getStringExtra("director_image")

        binding.txtDirectorName.setText(director_name)
        Glide
            .with(applicationContext)
            .load(director_image)
            .into(binding.imgDirectorName);
    }
}