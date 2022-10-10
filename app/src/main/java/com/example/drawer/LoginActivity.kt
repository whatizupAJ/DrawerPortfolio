package com.example.drawer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isLoggedIn()){
            launchMainActivity()
            finish()
        }
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        button = findViewById(R.id.button)

        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("LoginActivity","Login button clicked")
                if (isCredentialsValid()) {
                    saveCredentials()
                    launchMainActivity()
                    finish()
                }
            }
        })
    }

    private fun getMySharedPref(): SharedPreferences{
        return getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    private fun isLoggedIn(): Boolean{
        val sharedPreferences = getMySharedPref()

        val user_email = sharedPreferences.getString(Constants.EMAIL, null)

        return user_email != null
    }

    private fun launchMainActivity(){
        val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(mainIntent)
    }

    private fun isCredentialsValid(): Boolean {
        val user_email = email.text.toString()
        val user_password = password.text.toString()

        return user_email == "aj" && user_password == "ajdpajdp"
    }

    private fun saveCredentials() {
        val sharedPreferences =
            getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)

        val user_email = email.text.toString()
        sharedPreferences.edit().putString(Constants.EMAIL, user_email).apply()
    }
}