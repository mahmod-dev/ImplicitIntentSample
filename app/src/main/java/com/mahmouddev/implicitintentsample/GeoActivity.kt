package com.mahmouddev.implicitintentsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmouddev.implicitintentsample.databinding.ActivityGeoBinding

class GeoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGeoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnOpenMap.setOnClickListener {
                val lat = etLat.text.toString().trim()
                val lng = etLng.text.toString().trim()
                mapIntent(lat,lng)
            }
        }
    }

    private fun mapIntent(latitude: String, longitude: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("geo:$latitude,$longitude")
        startActivity(intent)
    }
}