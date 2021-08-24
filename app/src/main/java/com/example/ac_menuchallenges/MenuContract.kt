package com.example.ac_menuchallenges

import com.example.ac_menuchallenges.adapter.OnChallengeClicked

interface MenuContract {
    interface Presenter {
        fun init(challengeClicked: OnChallengeClicked)
        fun challengeClicked(challenge: String)
    }

    interface Model{
        var challengesList: List<String>
    }

    interface View{
        fun showChallengeList(challenges: List<String>, challengeClicked: OnChallengeClicked)
        fun initFragments()
        fun initFragmentNavComp()
        fun initScrollview()
        fun initApiMovieActivity()
        fun initDialogs()
        fun initScreen()
        fun initGridView()
    }
}