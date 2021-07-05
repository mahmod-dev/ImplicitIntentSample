package com.mahmouddev.implicitintentsample.utils

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.ContactsContract
import java.io.ByteArrayOutputStream


object DialerHelper {

    fun smsMessage(activity: Activity, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("smsto:$phoneNumber")
        //   intent.putExtra("sms_body", "")
        activity.startActivity(intent)
    }



}