package com.example.chicko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chicko.adapter.ProviderItemAdapter
import com.example.chicko.data.ProviderItemsDataSource
import com.example.chicko.databinding.ActivityProvidersBinding

class ProvidersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProvidersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProvidersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showProviders()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
//                    binding.bottomNavigation.selectedItemId = R.id.page_1

                    // Create an intent with a destination of ProvidersActivity
                    val intent = Intent(this, HomeActivity::class.java)

                    // Start an activity using the data and destination from the Intent.
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun showProviders() {
        // Initialize data.
        val myDataset = ProviderItemsDataSource().loadProviderItems()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = ProviderItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}