package com.mahmouddev.implicitintentsample

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.dhaval2404.imagepicker.ImagePicker
import com.mahmouddev.implicitintentsample.databinding.ActivityAddContactBinding
import com.mahmouddev.implicitintentsample.utils.ContactHelper.openContactScreen
import com.mahmouddev.implicitintentsample.utils.ImagePickerHelper

class AddContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddContactBinding
    private var bitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            imgContact.setOnClickListener {
                ImagePickerHelper.selectImageDialog(this@AddContactActivity, true)
            }

            btnAddContact.setOnClickListener {
                val firstName = etFirstName.text.toString().trim()
                val lastName = etLastName.text.toString().trim()
                val number = etNumber.text.toString().trim()
                val address = etAddress.text.toString().trim()
                val email = etEmail.text.toString().trim()

                openContactScreen("$firstName $lastName", email, address, number)
            }
        }
    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == ImagePicker.REQUEST_CODE) {

            val fileUri = data?.data
            binding.imgContact.setImageURI(fileUri)

            val filePath: String? = ImagePicker.getFilePath(data)
            bitmap = BitmapFactory.decodeFile(filePath)
            binding.imgCam.visibility = View.GONE

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

}