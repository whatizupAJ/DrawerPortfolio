package com.example.movies

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.drawer.R

class MovieDetails: AppCompatActivity(){

    private lateinit var rvdMovies: ImageView
    private lateinit var rvdTitle: TextView
    private lateinit var rvdRating: RatingBar
    private lateinit var rvdPlot: TextView
    private lateinit var rvdCast: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        rvdTitle = findViewById(R.id.rvdTitle)
        rvdMovies = findViewById(R.id.rvdMovies)
        rvdPlot = findViewById(R.id.rvdPlot)
        rvdRating = findViewById(R.id.rvdRating)
        rvdCast = findViewById(R.id.rvdCast)

        val title = intent.getStringExtra(moviesconstants.TITLE)
        val poster = intent.getIntExtra(moviesconstants.POSTER, 0)
        val plot = intent.getStringExtra(moviesconstants.PLOT)
        val rating = intent.getFloatExtra(moviesconstants.RATING, 0.0F)
        val cast = intent.getStringExtra(moviesconstants.CAST)

        rvdTitle.text = title
        rvdMovies.setImageResource(poster)
        rvdPlot.text = plot
        rvdRating.rating = rating
        rvdCast.text = cast

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}