package com.mahmouddev.implicitintentsample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.mahmouddev.implicitintentsample.databinding.ActivityBrowsingBinding

class BrowsingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBrowsingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowsingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnGoToWebsite.setOnClickListener {
                val url = etUrl.text.toString().trim()
                if (Patterns.WEB_URL.matcher(url).matches()&& url.isNotEmpty())
                    goToWebsiteIntent(url)
                else
                    Toast.makeText(this@BrowsingActivity, "Invalid URL!", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun goToWebsiteIntent(url: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}