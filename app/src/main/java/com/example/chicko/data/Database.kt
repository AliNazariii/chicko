package com.example.chicko.data

import com.example.chicko.model.Comment
import com.example.chicko.model.Service
import com.example.chicko.model.User

class Database {
    companion object {
        val USERS = mutableListOf<User>(
            User(firstName = "Muhammad", lastName = "Azhdari", userName = "havig", "pass"),
            User(firstName = "Ali", lastName = "Nazari", userName = "shalgham", "pass"),
            User(firstName = "Yashar", lastName = "Jahanshahlou", userName = "piaz", "pass"),
        )
        val Services = mutableListOf<Service>(
            Service(1, "لوله کشی آقا بزرگ", address = "Tehran", phone = "123456"),
            Service(2, "میوه فروشی سید", address = "Tehran", phone = "123455"),
            Service(3, "تعمیرات لپ تاپ منچستر", address = "Tehran", phone = "123454"),
            Service(4, "نظافت ساختمان با دانا", address = "Tehran", phone = "123453"),
            Service(5, "نانوایی شاطر عباس", address = "Tehran", phone = "123452"),
        )

        val COMMENTS = mutableListOf<Comment>(
            Comment("havig",1, "test"),
            Comment("havig",2, "test"),
            Comment("havig",3, "test"),
            Comment("havig",4, "test"),
            Comment("havig",5, "test"),
            Comment("havig",6, "test"),
        )

    }
}