package com.example.sheridancollege.prog39402.thinh.ravi.rumleen

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.ActivitySignUpBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.User
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.user.UserViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale



class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    val myCalendar = Calendar.getInstance()
    private lateinit var userViewModel: UserViewModel
    var selectedOptionText = "Yes";
    lateinit var sharedPreferencesHelper :SharedPreferencesHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        setData()
        setListener()
    }

    fun setData(){
        sharedPreferencesHelper = SharedPreferencesHelper(applicationContext)
    }
    fun setListener(){

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbYes -> {
                    selectedOptionText = binding.rbYes.text.toString()
                }
                R.id.rbNo -> {
                    selectedOptionText = binding.rbNo.text.toString()
                }
            }
        }

        val date =
            OnDateSetListener { view, year, month, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDate()
            }


        binding.edtDob.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                this@SignUpActivity, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        })

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.imgHome.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            if(TextUtils.isEmpty(binding.edtName.text.toString())){
                binding.edtName.setError("PLease enter a Name")
            }
            else if(TextUtils.isEmpty(binding.edtEmail.text.toString())){
                binding.edtEmail.setError("PLease enter an Email")
            }
            else if(TextUtils.isEmpty(binding.edtContactNumber.text.toString())){
                binding.edtContactNumber.setError("PLease enter a contact number")
            }
            else if(TextUtils.isEmpty(binding.edtPassword.text.toString())){
                binding.edtPassword.setError("PLease enter a password")
            }
            else if(TextUtils.isEmpty(binding.edtAddress.text.toString())){
                binding.edtAddress.setError("PLease enter an address")
            }
            else if(TextUtils.isEmpty(binding.edtDob.text.toString())){
                binding.edtDob.setError("PLease select a birth date")
            }

            else{
                userViewModel.insert(applicationContext,
                    User(name = binding.edtName.text.toString(),
                        email = binding.edtEmail.text.toString(),
                        password = binding.edtPassword.text.toString(),
                        isChildren = selectedOptionText,
                        contactNumber = binding.edtContactNumber.text.toString(),
                        address = binding.edtAddress.text.toString(),
                        dob = binding.edtDob.text.toString(),
                        )
                )
                sharedPreferencesHelper.saveString("currentUserEmail", binding.edtEmail.text.toString())
                sharedPreferencesHelper.saveString("currentUserIsChildren", selectedOptionText)
                Toast.makeText(applicationContext,"Signed Up Successfully.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun updateDate() {
        val myFormat = "dd/MM/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH)
        binding.edtDob.setText(sdf.format(myCalendar.time))
    }
}