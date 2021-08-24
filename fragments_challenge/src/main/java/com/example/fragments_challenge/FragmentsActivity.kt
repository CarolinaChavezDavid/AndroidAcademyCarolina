package com.example.fragments_challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments_challenge.databinding.ActivityMainBinding

class FragmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val fragmentA = AFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.myNavHostFragment, fragmentA).commit()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, FragmentsActivity::class.java)
    }
}