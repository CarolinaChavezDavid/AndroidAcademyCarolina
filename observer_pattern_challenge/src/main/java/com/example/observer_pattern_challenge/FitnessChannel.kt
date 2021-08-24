package com.example.observer_pattern_challenge

class FitnessChannel : Channel{
    override lateinit var videoTitle: String
    override var channelName: String = "Fitness Channel"
    var subscribers : MutableList<User> = mutableListOf()
    override fun notifyNewVide() {
        subscribers.forEach { it.update() }
    }

    override fun subscribe(user: User) {
        subscribers.add(user)
    }

    override fun unSubscribe(user: User) {
        subscribers.remove(user)
    }

    override fun uploadVideo(title: String) {
        videoTitle = title
        notifyNewVide()
    }
}