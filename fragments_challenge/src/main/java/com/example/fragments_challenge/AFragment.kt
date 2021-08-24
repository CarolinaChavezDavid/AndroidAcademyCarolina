package com.example.fragments_challenge

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments_challenge.databinding.FragmentABinding

private val  bFragment = BFragment()
class AFragment: Fragment() {
    private lateinit var bindingFragmentA: FragmentABinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        bindingFragmentA = FragmentABinding.inflate(layoutInflater, container, false)
        requireActivity().apply {
            bindingFragmentA.buttonFragmentA.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, bFragment)
                    .addToBackStack(null).commit()
                var valueA = addingA(Integer.parseInt(bindingFragmentA.valueA.text.toString()))
                bindingFragmentA.valueA.text = valueA.toString()
                val bundleA: Bundle = Bundle()
                bundleA.putInt("valueA", valueA)
                bFragment.arguments = bundleA
                getSharedPreferences("value",  AppCompatActivity.MODE_PRIVATE).edit().putInt("valueA", valueA).apply()
            }

            bindingFragmentA.buttonClean.setOnClickListener{
                getSharedPreferences("value",  AppCompatActivity.MODE_PRIVATE).edit().clear().commit()
                bindingFragmentA.valueA.text = "0"
            }
        }
        return bindingFragmentA.root
    }

    override fun onResume() {
        super.onResume()
        val preferences = this.activity?.getSharedPreferences("value", Context.MODE_PRIVATE)
        bindingFragmentA.valueA.text = preferences?.getInt("valueC", 0).toString()
    }

    private fun addingA(incremental: Int): Int{
        val incrementalA: Int = 5
        return incrementalA+incremental
    }

}