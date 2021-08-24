package com.example.observer_pattern_challenge

 class User(var name: String): Subscriber {
     lateinit var channelUser: Channel

     override fun subscribeChannel(channel: Channel) {
         channelUser = channel
     }

     override fun update() {
         println("Hey ${name}! ${channelUser.channelName} has uploaded a new video : ${channelUser.videoTitle}")
     }

 }