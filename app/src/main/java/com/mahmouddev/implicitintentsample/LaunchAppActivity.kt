package com.mahmouddev.implicitintentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mahmouddev.implicitintentsample.databinding.ActivityLaunchAppBinding

class LaunchAppActivity : AppCompatActivity() {
    val TAG = "LaunchAppActivity"
    private lateinit var binding: ActivityLaunchAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnOpnApp.setOnClickListener {
                val packageName = etPackageName.text.toString().trim()

                val launchIntent =
                    packageManager.getLaunchIntentForPackage(packageName)

                if (launchIntent != null) {
                    startActivity(launchIntent)
                } else {
                    Toast.makeText(this@LaunchAppActivity, "App not found!", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
    }
}