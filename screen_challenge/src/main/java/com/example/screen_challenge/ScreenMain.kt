package com.example.screen_challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screen_challenge.databinding.SheinLayoutBinding

class ScreenMain: AppCompatActivity(R.layout.shein_layout) {
    lateinit var bindingScreen : SheinLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingScreen = SheinLayoutBinding.inflate(layoutInflater)
        setContentView(bindingScreen.root)
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, ScreenMain::class.java)
    }
}