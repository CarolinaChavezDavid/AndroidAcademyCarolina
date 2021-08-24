package com.example.ac_menuchallenges.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ac_menuchallenges.R
import com.example.ac_menuchallenges.view.MenuViewHolder

class MenuAdapter(private val challenges: List<String>, private val challengeClicked: OnChallengeClicked)
    :RecyclerView.Adapter<MenuViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_challenge, parent, false)
        return MenuViewHolder(view, challengeClicked)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
       holder.binding(challenges[position])
    }

    override fun getItemCount(): Int = challenges.size
}