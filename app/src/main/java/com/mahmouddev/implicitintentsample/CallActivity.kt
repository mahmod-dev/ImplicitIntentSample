package com.mahmouddev.implicitintentsample

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mahmouddev.implicitintentsample.databinding.ActivityCallBinding
import com.mahmouddev.implicitintentsample.utils.CallHelper.Call_REQUEST_CODE
import com.mahmouddev.implicitintentsample.utils.CallHelper.callDialer
import com.mahmouddev.implicitintentsample.utils.CallHelper.isCallPhonePermissionGranted
import com.mahmouddev.implicitintentsample.utils.CallHelper.requestCallPhonePermission

class CallActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCallBinding
    var phone: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!isCallPhonePermissionGranted()) {
            Log.e("TAG", "isCallPhonePermissionGranted: ")
            requestCallPhonePermission()
        }

        binding.apply {
            btnCall.setOnClickListener {

                phone = etPhone.text.toString().trim()
                if (isCallPhonePermissionGranted()) {
                    if (!phone.isNullOrEmpty()) {
                        callDialer(phone!!)
                    } else {
                        Toast.makeText(this@CallActivity, "Empty!", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    requestCallPhonePermission()
                }
            }


        }


    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Call_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    //permission denied
                    Toast.makeText(this@CallActivity, "Permission Denied!", Toast.LENGTH_SHORT)
                        .show()

                } else {
                    //Permission granted
                    if (!phone.isNullOrEmpty()) {
                        callDialer(phone!!)
                    }

                }
            }
        }
    }
}