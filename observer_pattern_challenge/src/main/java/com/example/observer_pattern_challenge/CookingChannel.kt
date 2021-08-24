package com.example.observer_pattern_challenge

class CookingChannel() : Channel {
    override lateinit var videoTitle: String
    override var channelName: String = "Cooking Channel"
    var subscribers : MutableList<User> = mutableListOf()
    override fun notifyNewVide() {
        subscribers.forEach { it.update() }
        println("Cooking Channel upload new video")
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