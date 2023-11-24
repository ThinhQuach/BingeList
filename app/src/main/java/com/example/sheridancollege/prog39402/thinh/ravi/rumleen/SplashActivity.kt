package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.content.Intent
import android.net.sip.SipErrorCode.TIME_OUT
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferencesHelper :SharedPreferencesHelper
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        nextScreen()
    }
    fun setData(){
        sharedPreferencesHelper = SharedPreferencesHelper(applicationContext)
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_top)
        binding.imgBird.startAnimation(animation)
    }
    private fun nextScreen() {
        val currentUserEmail = sharedPreferencesHelper.getString("currentUserEmail")
        Handler().postDelayed(Runnable {
            if(TextUtils.isEmpty(currentUserEmail)){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 4000)


    }
}