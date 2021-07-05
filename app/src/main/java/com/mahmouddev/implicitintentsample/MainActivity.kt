package com.mahmouddev.implicitintentsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmouddev.implicitintentsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCall.setOnClickListener {
            navigateToToActivity(CallActivity::class.java)
        }

        binding.tvContact.setOnClickListener {
            navigateToToActivity(AddContactActivity::class.java)
        }

        binding.tvSendSms.setOnClickListener {
            navigateToToActivity(AddSmsActivity::class.java)
        }

        binding.tvSite.setOnClickListener {
            navigateToToActivity(BrowsingActivity::class.java)
        }

        binding.tvLocation.setOnClickListener {
            navigateToToActivity(GeoActivity::class.java)
        }

        binding.tvLaunchApp.setOnClickListener {
            navigateToToActivity(LaunchAppActivity::class.java)
        }

    }

    private fun navigateToToActivity(destActivity: Class<*>) {
        startActivity(Intent(this, destActivity))

    }
}