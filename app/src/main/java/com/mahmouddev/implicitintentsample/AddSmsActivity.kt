package com.mahmouddev.implicitintentsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmouddev.implicitintentsample.databinding.ActivityAddContactBinding
import com.mahmouddev.implicitintentsample.databinding.ActivityAddSmsBinding

class AddSmsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnGoSms.setOnClickListener {
                val phone = etPhone.text.toString().trim()
                val body = etBody.text.toString().trim()
                smsIntent(phone, body)
            }
        }


    }

    private fun smsIntent(phone: String, messageBody: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_SENDTO
        intent.data = Uri.parse("smsto:$phone")
        intent.putExtra("sms_body", messageBody)
        startActivity(intent)
    }
}