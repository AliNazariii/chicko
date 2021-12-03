package com.example.chicko.data

import com.example.chicko.R
import com.example.chicko.model.Comment
import com.example.chicko.model.ProviderItem
import com.example.chicko.model.Service

class ProviderItemsDataSource {

    fun getAllServices(): List<Service> {
        return Database.Services
    }

    fun getServiceByName(name: String): List<Service> {
        return Database.Services.filter { service -> service.name == name }
    }

    fun addComment(ownerName: String, serviceID: Int, content: String) {
        Database.COMMENTS.add(Comment(ownerName, serviceID, content))
    }

    fun getCommentsByServiceID(serviceID: Int): List<Comment> {
        return Database.COMMENTS.filter { comment -> comment.serviceID == serviceID }
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