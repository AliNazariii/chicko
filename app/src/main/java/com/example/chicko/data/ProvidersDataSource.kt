package com.example.chicko.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.chicko.R
import com.example.chicko.model.Category
import com.example.chicko.model.Comment
import com.example.chicko.model.Score
import com.example.chicko.model.Service

class ProvidersDataSource {

    companion object {

        fun getAllServices(): List<Service> {
            return Database.Services
        }

        fun getServiceByName(name: String): List<Service> {
            return Database.Services.filter { service -> service.name == name }
        }

        fun getServiceById(id: Int): Service? {
            return Database.Services.find { it.ID == id }
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

        fun getAverageScore(serviceID: Int): Float {
            val list = Database.Scores.filter { it.ServiceID == serviceID }
            val sum = list.sumOf { it.value }.toFloat()
            return sum / list.size
        }

        fun getTotalScoreCount(serviceID: Int) : Int {
            return Database.Scores.filter { it.ServiceID == serviceID }.size
        }
        //TODO
        fun getTotalCommentCount(serviceID: Int) : Int {
            return 123
        }
    }


    fun loadProviderItems(): List<ProviderData> {
        return Database.Services.map { ProviderData(it.ID, it.name, it.banner) }
    }
}

data class ProviderData(
    val id: Int,
    val name: String,
    @DrawableRes val BannerRid: Int
)