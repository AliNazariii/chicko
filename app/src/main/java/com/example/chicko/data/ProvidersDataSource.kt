package com.example.chicko.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.chicko.R
import com.example.chicko.model.Category
import com.example.chicko.model.Comment
import com.example.chicko.model.Score
import com.example.chicko.model.Service

class ProvidersDataSource {

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

    fun loadProviderItems(): List<ProviderData> {
        return listOf<ProviderData>(
            ProviderData(R.string.title_provider1, R.drawable.banner_provider1),
            ProviderData(R.string.title_provider2, R.drawable.banner_provider2),
            ProviderData(R.string.title_provider3, R.drawable.banner_provider3),
            ProviderData(R.string.title_provider4, R.drawable.banner_provider4),
            ProviderData(R.string.title_provider5, R.drawable.banner_provider5),
        )
    }
}

data class ProviderData(
    @StringRes val titleRId: Int,
    @DrawableRes val BannerRid: Int
)