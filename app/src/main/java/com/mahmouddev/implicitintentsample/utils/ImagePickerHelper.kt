package com.mahmouddev.implicitintentsample.utils

import android.app.Activity
import android.graphics.Color
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mahmouddev.implicitintentsample.R

object ImagePickerHelper {



    fun selectImageDialog(activity: Activity, isCrop: Boolean = false) {
        val options =
            arrayOf<CharSequence>(
                activity.resources.getString(R.string.take_photo),
                activity.getString(R.string.choose_gallery)
            )
        val builder = MaterialAlertDialogBuilder(activity, R.style.AlertDialogCustom)

        val title = TextView(activity)
        title.text = activity.getString(R.string.choose_pic)
        title.setPadding(30, 30, 30, 30)
        title.textSize = 18f
        title.typeface = ResourcesCompat.getFont(activity, R.font.montserrat_regular)

        title.setBackgroundColor(ContextCompat.getColor(activity, R.color.purple_100))
        title.setTextColor(Color.WHITE)

        builder.setCustomTitle(title)
        builder.setItems(options) { dialog, item ->
            val picker = ImagePicker.with(activity)
            if (options[item] == activity.resources.getString(R.string.take_photo)) {
                picker.cameraOnly()
            } else if (options[item] == activity.getString(R.string.choose_gallery)) {
                picker.galleryOnly()
            }

            if (isCrop) {
                picker.cropSquare()
            }else
                picker.crop()

            picker.start()
        }

        builder.setNegativeButton(activity.resources.getString(R.string.cancel)) { dialog, which ->
            dialog.dismiss()

        }
        builder.show()
    }





}