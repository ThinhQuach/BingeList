package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityForgotPasswordBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivityLoginBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserViewModel
import kotlinx.coroutines.launch

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        getsetData()
        setListener()
    }
    fun getsetData(){
        binding.imgBack.setOnClickListener {
            finish()
        }
        binding.imgHome.setOnClickListener {
            finish()
        }
       binding.btnOk.setOnClickListener {

           if(TextUtils.isEmpty(binding.edtEmail.text.toString())){
               binding.edtEmail.setError("PLease enter an Email")
           }
           else if(TextUtils.isEmpty(binding.edtNewPassword.text.toString())){
               binding.edtNewPassword.setError("PLease enter a new password")
           }
           else if(TextUtils.isEmpty(binding.edtReenterPwd.text.toString())){
               binding.edtReenterPwd.setError("PLease re-enter password")
           }
           else if(!binding.edtNewPassword.text.toString().equals(binding.edtReenterPwd.text.toString())){
               Toast.makeText(applicationContext,"New Password does'nt match with re- entered password", Toast.LENGTH_SHORT).show()
           }
           else {
               lifecycleScope.launch {
                   if(userViewModel.isEmailExists(binding.edtEmail.text.toString())){
                       userViewModel.updateUserPassword(applicationContext,
                           binding.edtEmail.text.toString(),
                           binding.edtNewPassword.text.toString(),
                       )
                       Toast.makeText(applicationContext,"Password changed successfully", Toast.LENGTH_SHORT).show()
                       finish()
                   }
                   else{
                       Toast.makeText(applicationContext,"This Email does'nt exist or an email you have entered is incorrect", Toast.LENGTH_SHORT).show()
                   }
               }

           }

       }
    }

    fun setListener(){

    }
}