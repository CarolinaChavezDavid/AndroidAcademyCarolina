package com.example.dialogs_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FragmentAdapter(private val answersOptions: List<Pair<String, Any>>
    , private val answerClicked: OnAnswerClicked)
    : RecyclerView.Adapter<FragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return FragmentViewHolder(view, answerClicked)
    }

    override fun onBindViewHolder(holder: FragmentViewHolder, position: Int) {
        holder.binding(answersOptions[position])
    }

    override fun getItemCount(): Int = answersOptions.size

}