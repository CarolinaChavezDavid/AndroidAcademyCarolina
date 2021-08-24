package com.example.ac_menuchallenges.entities

import com.example.ac_menuchallenges.MenuContract

class Model: MenuContract.Model {
    override var challengesList: List<String> = listOf(
        CHALLENGE_ONE, CHALLENGE_TWO, CHALLENGE_THREE, CHALLENGE_FOUR, CHALLENGE_FIVE
    , CHALLENGE_SIX, CHALLENGE_SEVEN,
    )

    companion object{
        const val CHALLENGE_ONE = "ScrollView"
        const val CHALLENGE_TWO = "Screen Shein"
        const val CHALLENGE_THREE= "Fragments"
        const val CHALLENGE_FOUR = "Fragments with NavComponents"
        const val CHALLENGE_FIVE = "API Challenge"
        const val CHALLENGE_SIX = "Dialogs"
        const val CHALLENGE_SEVEN = "GridView"
    }
}