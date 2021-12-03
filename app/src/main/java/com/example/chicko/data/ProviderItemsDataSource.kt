package com.example.chicko.data

import com.example.chicko.R
import com.example.chicko.model.ProviderItem
import com.example.chicko.model.Service

class ProviderItemsDataSource {

    fun getAllServices(): List<Service> {
        return Database.Services
    }

    fun loadProviderItems(): List<ProviderItem> {
        return listOf<ProviderItem>(
            ProviderItem(R.string.title_provider1, R.drawable.banner_provider1),
            ProviderItem(R.string.title_provider2, R.drawable.banner_provider2),
            ProviderItem(R.string.title_provider3, R.drawable.banner_provider3),
            ProviderItem(R.string.title_provider4, R.drawable.banner_provider4),
            ProviderItem(R.string.title_provider5, R.drawable.banner_provider5),
        )
    }
}