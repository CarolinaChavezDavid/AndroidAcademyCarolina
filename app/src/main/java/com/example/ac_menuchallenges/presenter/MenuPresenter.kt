package com.example.ac_menuchallenges.presenter

import com.example.ac_menuchallenges.MenuContract
import com.example.ac_menuchallenges.adapter.OnChallengeClicked
import com.example.ac_menuchallenges.entities.Model
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_FIVE
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_FOUR
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_ONE
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_SIX
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_THREE
import com.example.ac_menuchallenges.entities.Model.Companion.CHALLENGE_TWO
import com.example.ac_menuchallenges.view.MenuView

class MenuPresenter(private val model: Model, private  val view: MenuView)
    : MenuContract.Presenter
{
    override fun init(challengeClicked: OnChallengeClicked) {
        view.showChallengeList(model.challengesList, challengeClicked)
    }

    override fun challengeClicked(challenge: String) {
        when(challenge){
            CHALLENGE_ONE -> view.initScrollview()
            CHALLENGE_TWO -> view.initScreen()
            CHALLENGE_THREE -> view.initFragments()
            CHALLENGE_FOUR -> view. initFragmentNavComp()
            CHALLENGE_FIVE  -> view.initApiMovieActivity()
            CHALLENGE_SIX  -> view.initDialogs()
        }
    }
}