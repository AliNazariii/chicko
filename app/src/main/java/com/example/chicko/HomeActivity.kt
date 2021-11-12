package com.example.chicko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chicko.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_3 -> {
//                    binding.bottomNavigation.selectedItemId = item.itemId

                    // Create an intent with a destination of ProvidersActivity
                    val intent = Intent(this, ProvidersActivity::class.java)

                    // Start an activity using the data and destination from the Intent.
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}