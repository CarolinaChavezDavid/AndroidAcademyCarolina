package com.example.camara_challenge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.camara_challenge.databinding.ActivityImageBinding

private const val REQUEST_CODE = 10
const val REQUEST_IMAGE_CAPTURE = 1
typealias LumaListener = (luma: Double) -> Unit
class ImageActivity : AppCompatActivity() {

    private lateinit var activityImageBinding: ActivityImageBinding
    lateinit var buttonImage : Button
    lateinit var imageContainer : ImageView
    lateinit var buttoncamera : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityImageBinding = ActivityImageBinding.inflate(layoutInflater)

        buttoncamera = activityImageBinding.openCamara
        buttonImage = activityImageBinding.loadImage
        imageContainer = activityImageBinding.imageUploaded
        setContentView(activityImageBinding.root)

        val getImage =  registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                imageContainer.setImageURI(it)
            }
        )

        buttonImage.setOnClickListener{
            getImage.launch("image/*")
        }

        buttoncamera.setOnClickListener{
            startActivity(Intent(this, CameraActivity::class.java))
        }


    }


}



