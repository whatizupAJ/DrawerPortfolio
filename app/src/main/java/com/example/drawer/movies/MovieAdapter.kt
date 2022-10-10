package com.example.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.drawer.R

class MovieAdapter: Adapter <MovieAdapter.MovieViewHolder>(){

    //var onItemClicked: ((Movie:) -> Unit)?
    var onItemClickListener: OnItemClickListener? = null


    var movies: ArrayList<Movie> = ArrayList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_movies, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movies.get(position)

        holder.title.text = movie.title
        holder.rating.rating = movie.rating.toFloat()
        holder.movies.setImageResource(movie.poster)
        holder.date.text = movie.date

        holder.movies.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onItemClickListener?.onItemClicked(holder.adapterPosition)
            }
        })
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.rvTitle)
        val rating: RatingBar = itemView.findViewById(R.id.rvRating)
        val movies: ImageView = itemView.findViewById(R.id.rvMovies)
        val date: TextView = itemView.findViewById(R.id.rvDate)
    }
}