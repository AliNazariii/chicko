package com.example.chicko.data

import com.example.chicko.model.*

class Database {
    companion object {
        val Users = mutableListOf<User>(
            User(firstName = "Muhammad", lastName = "Azhdari", userName = "havig", "pass"),
            User(firstName = "Ali", lastName = "Nazari", userName = "shalgham", "pass"),
            User(firstName = "Yashar", lastName = "Jahanshahlou", userName = "piaz", "pass"),
        )

        val Categories = mutableListOf<Category>(
            Category(1, "عمومی"),
            Category(2, "تفریحی"),
            Category(3, "تغذیه"),
        )

        val Services = mutableListOf<Service>(
            Service(1, 1, "لوله کشی آقا بزرگ", address = "Tehran", phone = "123456", 1.0),
            Service(2, 3, "میوه فروشی سید", address = "Tehran", phone = "123455", 0.0),
            Service(3, 1, "تعمیرات لپ تاپ منچستر", address = "Tehran", phone = "123454", 0.0),
            Service(4, 1, "نظافت ساختمان با دانا", address = "Tehran", phone = "123453", 0.0),
            Service(5, 3, "نانوایی شاطر عباس", address = "Tehran", phone = "123452", 0.0),
            Service(6, 2, "کافه خل وچل‌ها", address = "Tehran", phone = "123452", 0.0),
        )

        val Scores = mutableListOf<Score>(
            Score("havig", 1, 2),
            Score("shalgham", 2, 4),
            Score("piaz", 3, 4),
        )

        val Comments = mutableListOf<Comment>(
            Comment("havig", 1, "test"),
            Comment("havig", 2, "test"),
            Comment("havig", 3, "test"),
            Comment("havig", 4, "test"),
            Comment("havig", 5, "test"),
            Comment("havig", 6, "test"),
        )
    }
}