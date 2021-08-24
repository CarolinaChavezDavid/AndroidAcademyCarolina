package com.example.ac_menuchallenges.view

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ac_menuchallenges.MenuContract
import com.example.ac_menuchallenges.adapter.MenuAdapter
import com.example.ac_menuchallenges.adapter.OnChallengeClicked
import com.example.ac_menuchallenges.databinding.ActivityMenuBinding
import com.example.api_challenge.view.ApiMovieActivity
import com.example.dialogs_challenge.DialogActivity
import com.example.fragments_challenge.FragmentsActivity
import com.example.grid_challenge.GridViewChallenge
import com.example.screen_challenge.ScreenMain

class MenuView(activity: Activity, var bindingMenuActivity: ActivityMenuBinding)
    : MenuContract.View, ActivityView(activity){

    override fun showChallengeList(challenges: List<String>, challengeClicked: OnChallengeClicked) {
        bindingMenuActivity.rvMenu.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MenuAdapter(challenges, challengeClicked)
        }
    }

    override fun initFragments() {
        activity?.let { it.startActivity(FragmentsActivity.newIntent(it))}
    }

    override fun initFragmentNavComp() {
        TODO("Not yet implemented")
    }

    override fun initScrollview() {
        TODO("Not yet implemented")
    }

    override fun initApiMovieActivity() {
        activity?.let { it.startActivity(ApiMovieActivity.newIntent(it))}
    }

    override fun initDialogs() {
        activity?.let { it.startActivity(DialogActivity.newIntent(it))}
    }

    override fun initScreen() {
        activity?.let { it.startActivity(ScreenMain.newIntent(it))}
    }

    override fun initGridView() {
        activity?.let { it.startActivity(GridViewChallenge.newIntent(it))}
    }
}