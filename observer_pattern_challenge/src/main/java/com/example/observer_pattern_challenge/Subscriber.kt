package com.example.observer_pattern_challenge

interface Subscriber {
    fun subscribeChannel(channel: Channel)
    fun update()
}