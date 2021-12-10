package com.example.chicko.data

import android.provider.ContactsContract
import com.example.chicko.R
import com.example.chicko.model.*

class ProviderItemsDataSource {

    fun getAllServices(): List<Service> {
        return Database.Services
    }

    fun getServiceByName(name: String): List<Service> {
        return Database.Services.filter { service -> service.name == name }
    }

    fun getServiceByCategoryID(catID: Int): List<Service> {
        return Database.Services.filter { service -> service.categoryID == catID }
    }

    fun addComment(ownerName: String, serviceID: Int, content: String) {
        Database.Comments.add(Comment(ownerName, serviceID, content))
    }

    fun getCommentsByServiceID(serviceID: Int): List<Comment> {
        return Database.Comments.filter { comment -> comment.serviceID == serviceID }
    }

    fun getAllCategories(): List<Category> {
        return Database.Categories
    }

    fun addScore(value: Int, userName: String, serviceID: Int) {
        // apply score to the service scores
        Database.Scores.add(Score(userName, serviceID, value))
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