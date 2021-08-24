package com.example.ac_menuchallenges.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ac_menuchallenges.adapter.OnChallengeClicked
import com.example.ac_menuchallenges.databinding.ItemChallengeBinding

class MenuViewHolder(itemView: View, private val challengeClicked: OnChallengeClicked)
    :RecyclerView.ViewHolder(itemView) {
        var challengeBinding = ItemChallengeBinding.bind(itemView)
        fun binding(item: String){
            challengeBinding.apply {
                itemChallenge.text = item
                itemChallenge.setOnClickListener {
                    challengeClicked.onChallengeClicked(item)
                }
            }
        }
}