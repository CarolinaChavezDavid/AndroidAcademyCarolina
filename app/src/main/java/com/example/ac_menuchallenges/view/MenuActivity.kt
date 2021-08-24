package com.example.ac_menuchallenges.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ac_menuchallenges.adapter.OnChallengeClicked
import com.example.ac_menuchallenges.databinding.ActivityMenuBinding
import com.example.ac_menuchallenges.entities.Model
import com.example.ac_menuchallenges.presenter.MenuPresenter

class MenuActivity: AppCompatActivity(), OnChallengeClicked  {
    private lateinit var  bindingMenuActivity: ActivityMenuBinding
    private lateinit var presenter :MenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenuActivity = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bindingMenuActivity.root)
        presenter = MenuPresenter(Model(), MenuView(this, bindingMenuActivity) )
        presenter.init(this)
    }

    override fun onChallengeClicked(challenge: String) {
       presenter.challengeClicked(challenge)
    }
}