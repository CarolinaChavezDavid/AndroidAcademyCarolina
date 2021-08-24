package com.example.dialogs_challenge

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogs_challenge.databinding.FragmentItemBinding

class FragmentViewHolder(itemView: View, private val answerClicked: OnAnswerClicked)
    :RecyclerView.ViewHolder(itemView) {
        var answerBinding = FragmentItemBinding.bind(itemView)
        fun binding(item: Pair<String, Any>){
            answerBinding.apply {
                answerImage.setImageResource(item.second as Int)
                answerText.text = item.first
                answerText.setOnClickListener {answerClicked.onAnswerClicked(item.first)}
                answerImage.setOnClickListener {answerClicked.onAnswerClicked(item.first)}
            }
        }
}