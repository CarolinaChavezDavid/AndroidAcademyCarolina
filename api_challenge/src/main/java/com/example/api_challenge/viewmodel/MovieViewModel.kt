package com.example.api_challenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api_challenge.model.MovieModel
import com.example.api_challenge.model.moviesapi.MovieApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieViewModel: ViewModel()  {

    var mutableLiveDataMovie = MutableLiveData<List<MovieModel>>()
    companion object {
        const val movieAPI = "https://api-movie-carolina.herokuapp.com/api/series/"
        const val TAG= "My fav movies"
    }

    private  val retrofit = Retrofit.Builder()
        .baseUrl(movieAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private  val service: MovieApiServices = retrofit.create(MovieApiServices :: class.java)

    fun getMovieList(){
        var call: Call<List<MovieModel>> = service.getMovieList()
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>?,
                response: Response<List<MovieModel>>?) {
                if (response != null) {
                    mutableLiveDataMovie.postValue( response.body())
                }
            }
            override fun onFailure(call: Call<List<MovieModel>>?, t: Throwable?) {
                call?.cancel()
            }
        })
    }
}