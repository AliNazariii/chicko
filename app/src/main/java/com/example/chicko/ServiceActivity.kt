package com.example.chicko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.ActivityMainBinding
import com.example.chicko.databinding.ActivityServiceBinding
import com.example.chicko.model.Service
import android.content.Intent
import android.net.Uri


class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding

    companion object {
        const val SERVICE_ID = "service_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent?.extras?.getInt(SERVICE_ID)
        val service = ProvidersDataSource.getServiceById(id!!)!!

        binding.title.text = service.name
        binding.addressTextview.text = service.address
        binding.phoneTextview.text = service.phone
        val averageScore = ProvidersDataSource.getAverageScore(service.ID)
        binding.scoreTextView.text = "${averageScore} / 5"
        binding.infoTextview.text = "${ProvidersDataSource.getTotalScoreCount(service.ID)} رای | ${
            ProvidersDataSource.getTotalCommentCount(service.ID)
        } نظر"
        binding.callBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + service.phone))
            startActivity(intent)
        }
    }
}