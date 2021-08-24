package com.example.api_challenge.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_challenge.databinding.ActivityApiBinding
import com.example.api_challenge.model.MovieModel
import com.example.api_challenge.viewmodel.MovieViewModel

class ApiMovieActivity : AppCompatActivity() {
    lateinit var bindingApp: ActivityApiBinding
    lateinit var rvMovies: RecyclerView
    lateinit var movieViewModel: MovieViewModel
    lateinit var movieAdapter : MovieAdapter
    private var movieList = listOf<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingApp = ActivityApiBinding.inflate(layoutInflater)
        setContentView(bindingApp.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieViewModel.getMovieList()
        movieViewModel.mutableLiveDataMovie.observe(this, Observer { list ->
            movieAdapter.setData(list)
        })
        rvMovies = bindingApp.rvMovies

        movieAdapter  = MovieAdapter(movieList, this)

        rvMovies.apply {
            layoutManager = GridLayoutManager(this@ApiMovieActivity, 2)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, ApiMovieActivity::class.java)
    }
}