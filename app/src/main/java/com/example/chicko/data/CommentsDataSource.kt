package com.example.chicko.data

import android.util.Log

class CommentsDataSource {

    fun loadComments(serviceId: Int): List<CommentData> {
        return Database.Comments.filter{it.serviceID == serviceId}.map { comment ->
            CommentData(
                comment.ownerUserName,
                comment.content)
        }
    }
}

data class CommentData(
    val userName: String,
    val content: String,
)