package com.shar.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){

    lateinit var etMno:EditText
    lateinit var etPswrd:EditText
    lateinit var btnButton1:Button
    lateinit var txtForgotPswrd:TextView
    lateinit var txtRegister:TextView
    val validMobileNumber = "9554789512"
    val validPassword = arrayOf("akhi_choda","gusain_bhadwa","panther","bruce","thor","widow")
    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_login)
        title="Log In"

        etMno = findViewById(R.id.etMno)
        etPswrd = findViewById(R.id.etPswrd)
        btnButton1 = findViewById(R.id.btnButton1)
        txtForgotPswrd = findViewById(R.id.txtForgotPswrd)
        txtRegister = findViewById(R.id.txtRegister)



        btnButton1.setOnClickListener {
            val mobileNumber = etMno.text.toString()
            val password = etPswrd.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)

            if((mobileNumber == validMobileNumber)) {
                if (password == validPassword[0]) {

                    nameOfAvenger = "WELCOME SHARDUL UPADHYAY"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                } else if (password == validPassword[1]) {

                    nameOfAvenger = "WELCOME CHIRAG SIR"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                } else if (password == validPassword[2]) {


                    nameOfAvenger = "WELCOME RAM"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)

                } else if (password == validPassword[3]) {

                    nameOfAvenger = "WELCOME DEEPAK"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                } else if (password == validPassword[4]) {


                    nameOfAvenger = "WELCOME RAMESH"

                    savePreferences(nameOfAvenger)


                    startActivity(intent)
                } else if (password == validPassword[5]) {

                    nameOfAvenger = "WELCOME SURESH"

                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                }
            }
                else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Incorrect Credentials",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
    }


    override fun onPause() {
        super.onPause()
        finish()
    }
fun savePreferences(title: String){
    sharedPreferences.edit().putBoolean("isLoggedin",true).apply()
    sharedPreferences.edit().putString("Title",title).apply()
}
}