package com.example.observer_pattern_challenge

interface Channel {
    var videoTitle :String
    var channelName :String
    fun notifyNewVide()
    fun subscribe(user: User)
    fun unSubscribe(user: User)
    fun uploadVideo(title: String)
}