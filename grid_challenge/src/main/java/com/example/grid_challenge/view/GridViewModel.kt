package com.example.grid_challenge.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.grid_challenge.data.ApiService
import com.example.grid_challenge.model.SerieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GridViewModel : ViewModel() {
    var mutableLiveDataSerie = MutableLiveData<List<SerieModel>>()
    var apiServiceSerie = ApiService()

    fun getSerieList(){
        var call: Call<List<SerieModel>> = apiServiceSerie.serieService.getSerieList()
        call.enqueue(object : Callback<List<SerieModel>>{
            override fun onResponse(
                call: Call<List<SerieModel>>?,
                response: Response<List<SerieModel>>?
            ) {
                if (response != null) {
                    mutableLiveDataSerie.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<SerieModel>>?, t: Throwable?) {
               call?.cancel()
            }

        })

    }
}