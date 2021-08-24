package com.example.api_challenge.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_challenge.R
import com.example.api_challenge.model.MovieModel

class MovieAdapter(private var movieList: List<MovieModel>, var context: Context):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    fun setData(list: List<MovieModel>){
        movieList = list
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var poster: ImageView = itemView.findViewById(R.id.movie_poster)
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var ratingBar: RatingBar = itemView.findViewById(R.id.movie_ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val element = movieList[position]
        holder.title.text = element.title
        holder.ratingBar.rating = element.rating.toFloat()
        Glide.with(context)
            .load(movieList[position].poster)
            .fitCenter()
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
            return movieList.size
    }
}