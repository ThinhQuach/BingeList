package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityLoginBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferencesHelper :SharedPreferencesHelper
    private lateinit var userViewModel: UserViewModel
    var users : ArrayList<User> = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        setData()
        setListener()
    }

    fun setData(){
        sharedPreferencesHelper = SharedPreferencesHelper(applicationContext)

        userViewModel.getAllUsers(applicationContext).observe(this, Observer {
            users = it as ArrayList<User>
        })
    }

    fun setListener(){
        binding.txtForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignIn.setOnClickListener {
            if(TextUtils.isEmpty(binding.edtEmail.text.toString())){
                binding.edtEmail.setError("PLease enter an Email")
            }
            else if(TextUtils.isEmpty(binding.edtPassword.text.toString())){
                binding.edtPassword.setError("PLease enter a password")
            }
            else{
                lifecycleScope.launch {
                    val loginSuccessful = userViewModel.verifyLogin(binding.edtEmail.text.toString(),
                        binding.edtPassword.text.toString())

                    if(userViewModel.isEmailExists(binding.edtEmail.text.toString())){
                        if(!loginSuccessful){
                            Toast.makeText(applicationContext,"InCorrectPassword", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            sharedPreferencesHelper.saveString("currentUserEmail", binding.edtEmail.text.toString())
                            var user = userViewModel.getUserByEmail2(binding.edtEmail.text.toString())
                            sharedPreferencesHelper.saveString("currentUserIsChildren",user.isChildren.toString() )
                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    else{
                        Toast.makeText(applicationContext,"This Email does'nt exist or an email you have entered is incorrect", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}