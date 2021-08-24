package com.example.api_challenge.data

import androidx.lifecycle.MutableLiveData
import com.example.api_challenge.model.MovieModel
import com.example.api_challenge.model.moviesapi.MovieApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    lateinit var mutableLiveDataMovie : MutableLiveData<List<MovieModel>>

    companion object {
        const val movieAPI = "https://api-movie-carolina.herokuapp.com/api/"
        const val TAG= "My fav movies"
    }

    private  val retrofit = Retrofit.Builder()
        .baseUrl(movieAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private  val service: MovieApiServices = retrofit.create(MovieApiServices :: class.java)

    fun getMovieList(): MutableLiveData<List<MovieModel>>{
        var call: Call<List<MovieModel>> = service.getMovieList()
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>?,
                response: Response<List<MovieModel>>?) {
                if (response != null) {
                   mutableLiveDataMovie.postValue(response.body())

                }
            }
            override fun onFailure(call: Call<List<MovieModel>>?, t: Throwable?) {
                call?.cancel()
            }
        })
        return mutableLiveDataMovie
    }
}