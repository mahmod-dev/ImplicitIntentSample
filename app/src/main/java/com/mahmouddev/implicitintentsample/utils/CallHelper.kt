package com.mahmouddev.implicitintentsample.utils

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object CallHelper {


     const val Call_REQUEST_CODE: Int = 201

    fun Activity.callDialer(number: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

     fun Activity.isCallPhonePermissionGranted(): Boolean {
        val permission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        )

        return permission == PackageManager.PERMISSION_GRANTED

    }

     fun Activity.requestCallPhonePermission() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE),
            Call_REQUEST_CODE)
    }


}