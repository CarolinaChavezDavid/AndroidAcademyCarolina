package com.example.grid_challenge.data

import com.example.grid_challenge.model.SerieApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        const val serieAPI = "https://api-movie-carolina.herokuapp.com/api/"
        const val TAG= "My fav movies"
    }

    private  val retrofit = Retrofit.Builder()
        .baseUrl(serieAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

         var serieService : SerieApiService = retrofit.create(SerieApiService :: class.java)

}