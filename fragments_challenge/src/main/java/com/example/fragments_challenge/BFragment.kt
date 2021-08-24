package com.example.fragments_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments_challenge.databinding.FragmentBBinding

private val  cFragment = CFragment()
class BFragment: Fragment() {

    lateinit var bindingFragmentB: FragmentBBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        bindingFragmentB = FragmentBBinding.inflate(layoutInflater, container, false)

        val valueGet = arguments?.getInt("valueA")
        bindingFragmentB.valueB.text = valueGet.toString()
        requireActivity().apply {
            bindingFragmentB.buttonFragmentB.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, cFragment)
                    .addToBackStack(null).commit()
                var valueB = addingB(Integer.parseInt(bindingFragmentB.valueB.text.toString()))
                bindingFragmentB.valueB.text = valueB.toString()
                val bundleB: Bundle = Bundle()
                bundleB.putInt("valueB", valueB)
                cFragment.arguments = bundleB
                getSharedPreferences("value",  AppCompatActivity.MODE_PRIVATE).edit().putInt("valueB", valueB).apply()
            }
        }
        return bindingFragmentB.root
    }

    private fun addingB(incremental: Int): Int{
        val incrementalB: Int = 3
        return incrementalB+incremental
    }

}