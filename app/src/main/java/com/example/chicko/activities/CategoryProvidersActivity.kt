package com.example.chicko.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chicko.adapter.ProvidersAdapter
import com.example.chicko.data.CategoriesDataSource
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.ActivityCategoryProvidersBinding
import com.example.chicko.model.Category

class CategoryProvidersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryProvidersBinding

    companion object {
        const val CATEGORY_ID = "category_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryProvidersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent?.extras?.getInt(CATEGORY_ID)
        val category = CategoriesDataSource.getCategoryById(id!!)!!

        // action bar title
        title = category.name

        prepareList(category)
    }

    private fun prepareList(category: Category) {
        val recyclerView = binding.categoryProvidersRecyclerView
        val dataSet = ProvidersDataSource.loadCategoryProviderItems(category.ID)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProvidersAdapter(this, dataSet)
    }
}