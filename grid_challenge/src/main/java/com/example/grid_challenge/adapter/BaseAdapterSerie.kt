package com.example.grid_challenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.grid_challenge.R
import com.example.grid_challenge.model.SerieModel

class BaseAdapterSerie(var context: Context?  = null, var serieList : List<SerieModel> = listOf())
    : BaseAdapter() {
   // var serieList : List<SerieModel>
    //var context : Context?

    fun setData(list: List<SerieModel>){
        serieList = list
        notifyDataSetChanged()
    }

   /** constructor(context: Context, serieList : List<SerieModel>):super() {
        this.context = context
        this.serieList = serieList
    }**/
    override fun getCount(): Int = serieList.size

    override fun getItem(position: Int): Any  = serieList[position]

    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val serie = this.serieList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var gridView =  inflator.inflate(R.layout.grid_item, null)
        Glide.with(context!!)
            .load(serie.poster)
            .fitCenter()
            .into(gridView.findViewById(R.id.posterSerie))
        gridView.findViewById<TextView>(R.id.title_serie).text = serie.title
        gridView.findViewById<RatingBar>(R.id.rating_serie).rating = serie.rating.toFloat()

        return gridView

    }
}