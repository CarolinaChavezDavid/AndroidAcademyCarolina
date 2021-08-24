package com.example.grid_challenge.model

import retrofit2.http.GET

interface SerieApiService {
    @GET("series/")
    fun getSerieList(): retrofit2.Call<List<SerieModel>>
}