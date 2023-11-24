package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivitySplashBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityTvshowDetailBinding

class TVShowDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvshowDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}