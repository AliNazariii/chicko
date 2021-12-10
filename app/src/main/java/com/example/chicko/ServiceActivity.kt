package com.example.chicko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chicko.databinding.ActivityMainBinding
import com.example.chicko.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addressTextview.text = "فلان جا، خیابان فلان"
        binding.phoneTextview.text = "فلان جا، خیابان فلان"
        binding.rateTextview.text = "فلان جا، خیابان فلان"
        binding.scoreTextView.text = "4.5 / 5"
        binding.infoTextview.text = "123 رای | 12 نظر"
    }
}