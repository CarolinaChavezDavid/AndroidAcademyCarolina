package com.example.api_challenge.model.moviesapi

import com.example.api_challenge.model.MovieModel
import retrofit2.http.GET

interface MovieApiServices {
    @GET("movies/")
    fun getMovieList(): retrofit2.Call<List<MovieModel>>
}