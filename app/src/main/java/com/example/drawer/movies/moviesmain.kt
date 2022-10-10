package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.example.drawer.R
import com.example.drawer.R.id.rvMovies

class moviesmain : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private val movies: ArrayList<Movie> = ArrayList()
    private var movieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        rvMovies = findViewById(R.id.rvMovies)

        movieAdapter.onItemClickListener = object:OnItemClickListener{
            override fun onItemClicked(position: Int) {
                val selectedMovie = movieAdapter.movies.get(position)
                movieDetails(selectedMovie)
            }
        }

        initializeMovies()
        supportActionBar?.title = "Movies"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun movieDetails(selectedMovie: Movie){

        val movieDetail = Intent(this, MovieDetails::class.java)
        movieDetail.putExtra(moviesconstants.TITLE, selectedMovie.title)
        movieDetail.putExtra(moviesconstants.POSTER, selectedMovie.poster)
        movieDetail.putExtra(moviesconstants.RATING, selectedMovie.rating)
        movieDetail.putExtra(moviesconstants.PLOT, selectedMovie.plot)
        movieDetail.putExtra(moviesconstants.CAST, selectedMovie.cast)


        //val selectedMovie: Movie = movieAdapter.movies(moviesPosition)

        startActivity(movieDetail)

        Log.d("MainActivity", "$selectedMovie")
    }

    private fun initializeMovies(){
        movies.add(Movie("Spiderman", R.drawable.spiderman, 5.0F, "(December 1, 2018)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", "\t\n" +
                "Shameik Moore\n" +
                "Jake Johnson\n" +
                "Hailee Steinfeld\n" +
                "Mahershala Ali\n" +
                "Brian Tyree Henry\n" +
                "Lily Tomlin\n" +
                "Luna Lauren Vélez\n" +
                "John Mulaney\n" +
                "Kimiko Glenn\n" +
                "Nicolas Cage\n" +
                "Liev Schreiber"))
        movies.add(Movie("Avengers", R.drawable.avengers, 4.9F, "(April 25, 2018)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "\t\n" +
                "Robert Downey Jr.\n" +
                "Chris Hemsworth\n" +
                "Mark Ruffalo\n" +
                "Chris Evans\n" +
                "Scarlett Johansson\n" +
                "Benedict Cumberbatch\n" +
                "Don Cheadle\n" +
                "Tom Holland\n" +
                "Chadwick Boseman\n" +
                "Paul Bettany\n" +
                "Elizabeth Olsen\n" +
                "Anthony Mackie\n" +
                "Sebastian Stan\n" +
                "Danai Gurira\n" +
                "Letitia Wright\n" +
                "Dave Bautista\n" +
                "Zoe Saldaña\n" +
                "Josh Brolin\n" +
                "Chris Pratt"))
        movies.add(Movie("Black Panther", R.drawable.black_panther, 5.0F, "(February 14, 2018)", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Chadwick Boseman\n" +
                "Michael B. Jordan\n" +
                "Lupita Nyong'o\n" +
                "Danai Gurira\n" +
                "Martin Freeman\n" +
                "Daniel Kaluuya\n" +
                "Letitia Wright\n" +
                "Winston Duke\n" +
                "Angela Bassett\n" +
                "Forest Whitaker\n" +
                "Andy Serkis"))
        movies.add(Movie("Frozen 2", R.drawable.frozen, 4.5F, "(November 20, 2019)", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "\t\n" +
                "Kristen Bell\n" +
                "Idina Menzel\n" +
                "Josh Gad\n" +
                "Jonathan Groff"))
        movies.add(Movie("Three Idiots", R.drawable.three_idiots, 4.5F, "(May 8, 2013)", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "\t\n" +
                "Aamir Khan\n" +
                "R. Madhavan\n" +
                "Sharman Joshi\n" +
                "Omi Vaidya\n" +
                "Kareena Kapoor\n" +
                "Boman Irani"))
        movies.add(Movie("Everything, Everywhere, All at once", 0, 4.0F, "", "", ""))
        movies.add(Movie("Doctor Strange", 0, 4.0F, "", "", ""))
        movies.add(Movie("Parasite", 0, 5.0F, "", "", ""))
        movies.add(Movie("BuyBust", 0, 5.0F, "", "", ""))
        movies.add(Movie("Deadpool", 0, 4.9F, "", "", ""))

        movieAdapter.movies = movies

        rvMovies.adapter = movieAdapter

        Log.d("Main Activity", movies.toString())

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