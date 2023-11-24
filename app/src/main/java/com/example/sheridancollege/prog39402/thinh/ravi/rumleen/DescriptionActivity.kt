package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityCastBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding
    var description : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        setListener()

    }

    fun  getData(){
        description = intent.getStringExtra("description")
        binding.txtDescription.setText(description)
    }
    fun  setListener(){
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.imgHome.setOnClickListener {
            finish()
        }
    }
}