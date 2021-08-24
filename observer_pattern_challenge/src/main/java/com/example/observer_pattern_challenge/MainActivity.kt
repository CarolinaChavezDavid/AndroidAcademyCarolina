package com.example.observer_pattern_challenge

fun main(){
    var cookingChannel = CookingChannel()
    var fitnessChannel = FitnessChannel()
    var developerChannel = DeveloperChannel()

    var user1 = User("Carolina")
    var user2 = User("Susana")
    var user3 = User("Helena")
    var user4 = User("Pablito")
    var user5 = User("Josesito")
    var user6 = User("camilo")

    cookingChannel.subscribe(user1)
    cookingChannel.subscribe(user3)
    fitnessChannel.subscribe(user2)
    fitnessChannel.subscribe(user6)
    developerChannel.subscribe(user4)
    developerChannel.subscribe(user5)

    user1.subscribeChannel(cookingChannel)
    user3.subscribeChannel(cookingChannel)
    user2.subscribeChannel(fitnessChannel)
    user6.subscribeChannel(fitnessChannel)
    user4.subscribeChannel(developerChannel)
    user5.subscribeChannel(developerChannel)

    cookingChannel.uploadVideo("How to cook a pretzel")
    fitnessChannel.uploadVideo("Full abs routine")
    developerChannel.uploadVideo("How to work with RxJava")



}