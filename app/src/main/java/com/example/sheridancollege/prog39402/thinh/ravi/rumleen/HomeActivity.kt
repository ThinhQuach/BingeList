package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferencesHelper : SharedPreferencesHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigation()
        setListener()
    }
    fun setNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        sharedPreferencesHelper = SharedPreferencesHelper(applicationContext)

    }

    fun setListener(){
        binding.llLogout.setOnClickListener{
            sharedPreferencesHelper.clearPreferences()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}