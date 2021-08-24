package com.example.grid_challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.grid_challenge.adapter.BaseAdapterSerie
import com.example.grid_challenge.databinding.ActivityGridViewChallengeBinding
import com.example.grid_challenge.model.SerieModel
import com.example.grid_challenge.view.GridViewModel

class GridViewChallenge : AppCompatActivity() {
    lateinit var activityGridBinding : ActivityGridViewChallengeBinding
    lateinit var gridViewModel : GridViewModel
    lateinit var gridView : GridView
    lateinit var baseAdapterSerie: BaseAdapterSerie
    private  var  serieList = listOf<SerieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGridBinding = ActivityGridViewChallengeBinding.inflate(layoutInflater)
        setContentView(activityGridBinding.root)
        initGridView()
    }

    fun initGridView(){
        gridViewModel = ViewModelProvider(this).get(GridViewModel :: class.java)
        gridViewModel.getSerieList()
        gridViewModel.mutableLiveDataSerie.observe(this, Observer { list ->
            baseAdapterSerie.setData(list)
        })
        gridView = activityGridBinding.gridSerie
        baseAdapterSerie = BaseAdapterSerie(this, serieList)
        gridView.adapter = baseAdapterSerie
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, GridViewChallenge::class.java)
    }
}