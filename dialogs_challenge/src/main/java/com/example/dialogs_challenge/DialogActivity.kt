package com.example.dialogs_challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dialogs_challenge.databinding.ActivityDialogsBinding
import com.example.dialogs_challenge.databinding.CustomDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDialogsBinding
    private var customDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nativeDialog.setOnClickListener { showNativeDialog() }
        binding.customDialog.setOnClickListener { showCustomDialog() }

    }

    fun showNativeDialog(){
        val builder = MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
        val dialog =builder
            .setTitle(resources.getString(R.string.dialog_native))
            .setMessage(resources.getString(R.string.d2_native))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                this.showToast(resources.getString(R.string.cancel))
                dialog.dismiss()
            }
            .setNegativeButton(resources.getString(R.string.decline)) { dialog, _ ->
                showToast(resources.getString(R.string.decline))
                dialog.dismiss()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { dialog, _ ->
                showToast(resources.getString(R.string.accept))
                dialog.dismiss()
            }
            .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_spaceship_2  ))
            .setCancelable(false)
            .create()
        dialog.show()
    }

    private fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showCustomDialog(){
        val dialogCustomBinding = CustomDialogBinding.inflate(layoutInflater)
        dialogCustomBinding.noOption.setOnClickListener { customDialog?.dismiss() }
        dialogCustomBinding.maybeLaterOption.setOnClickListener {showToast(resources.getString(R.string.decline))}
        dialogCustomBinding.yesOption.setOnClickListener {
            //startActivity(Intent(this, MenuActivity::class.java ))
        }
        customDialog =MaterialAlertDialogBuilder(this)
            .setView(dialogCustomBinding.root)
            .setCancelable(false)
            .create()
        customDialog?.show()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, DialogActivity::class.java)
    }
}