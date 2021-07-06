package com.mahmouddev.implicitintentsample

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
            navigateToActivity(CallActivity::class.java)
        }

        binding.tvContact.setOnClickListener {
            navigateToActivity(AddContactActivity::class.java)
        }

        binding.tvSendSms.setOnClickListener {
            navigateToActivity(AddSmsActivity::class.java)
        }

        binding.tvSite.setOnClickListener {
            navigateToActivity(BrowsingActivity::class.java)
        }

        binding.tvLocation.setOnClickListener {
            navigateToActivity(GeoActivity::class.java)
        }

        binding.tvLaunchApp.setOnClickListener {
            navigateToActivity(LaunchAppActivity::class.java)
        }

    }

    private fun navigateToActivity(destActivity: Class<*>) {
        startActivity(Intent(this, destActivity))

    }
}