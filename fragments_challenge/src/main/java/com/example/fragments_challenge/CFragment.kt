package com.example.fragments_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments_challenge.databinding.FragmentCBinding

private val  aFragment = AFragment()
class CFragment: Fragment() {
    private lateinit var bindingFragmentC: FragmentCBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        bindingFragmentC = FragmentCBinding.inflate(layoutInflater, container, false)
        val valueGet = arguments?.getInt("valueB")
        bindingFragmentC.valueC.text = valueGet.toString()

        requireActivity().apply{
            bindingFragmentC.buttonFragmentC.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, aFragment).commit()
                var valueC = addingC(Integer.parseInt(bindingFragmentC.valueC.text.toString()))
                bindingFragmentC.valueC.text = valueC.toString()
                val bundleC: Bundle = Bundle()
                bundleC.putInt("valueC", valueC)
                AFragment().arguments = bundleC
                getSharedPreferences("value",  AppCompatActivity.MODE_PRIVATE).edit().putInt("valueC", valueC).apply()
            }

            /**onBackPressedDispatcher?.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    supportFragmentManager. beginTransaction().replace(R.id.fragment_container, aFragment).commit()
                }
            }
            )**/
        }

        return bindingFragmentC.root
    }


    private fun addingC(incremental: Int): Int {
        val incrementalC: Int = 2
        return incrementalC + incremental

    }
}