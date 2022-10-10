package com.example.drawer

import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import com.example.drawer.calculator.tipcalculatormain
import com.example.movies.moviesmain
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var ivAvatar: ImageView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarDrawerToggle= ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView = findViewById(R.id.navView)
        navigationView.setNavigationItemSelectedListener(this)
        tvEmail = navigationView.getHeaderView(0).findViewById(R.id.tvEmail)

        val sharedPreferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val user_email = sharedPreferences.getString(Constants.EMAIL, null)


        tvEmail.text = user_email

        //sharedPreferences.edit().remove().apply()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }


        return super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem):Boolean{
        when (item.itemId){

            R.id.action_calculator->{
                val calculatorIntent = Intent(this, tipcalculatormain::class.java)
                startActivity(calculatorIntent)
            }

            R.id.action_movies->{
                val moviesIntent = Intent(this, moviesmain::class.java)
                startActivity(moviesIntent)
            }
            R.id.action_logout ->{

                AlertDialog.Builder(this)
                    .setTitle("Logout?")
                    .setPositiveButton("Cancel", object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("Main activity", "logout confirmed")

                        }
                    })

                    .setNegativeButton("OK", object : OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("Main activity", "logout confirmed")

                            val prefs = getSharedPreferences(
                                Constants.PREFERENCE_NAME,
                                Context.MODE_PRIVATE
                            )

                            prefs.edit()
                                .remove(Constants.EMAIL)
                                .apply()

                            val logIntent = Intent(this@MainActivity, LoginActivity::class.java)
                            startActivity(logIntent)
                            finish()
                        }
                    }).show()
                Log.d("Main activity", "Logout")

            }
        }
        return false
    }
}