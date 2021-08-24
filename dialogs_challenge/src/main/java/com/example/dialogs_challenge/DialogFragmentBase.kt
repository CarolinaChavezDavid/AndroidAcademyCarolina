package com.example.dialogs_challenge

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dialogs_challenge.databinding.FragmentDialogBinding


class DialogFragmentBase(context: Context, var adapterFragment: FragmentAdapter) : DialogFragment() {
    lateinit var bindingFragment: FragmentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentDialogBinding.inflate(layoutInflater)
        bindingFragment.rvAnswer.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterFragment
        }
        bindingFragment.frangmentCancel.setOnClickListener{
            dismiss()
        }

        return  bindingFragment.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog?.setCancelable(false)
    }
}