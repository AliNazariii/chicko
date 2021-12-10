package com.example.chicko.data

import com.example.chicko.R
import com.example.chicko.model.*

class Database {
    companion object {
        val Users = mutableListOf<User>(
            User(firstName = "Muhammad", lastName = "Azhdari", userName = "havig", "12345"),
            User(firstName = "Ali", lastName = "Nazari", userName = "shalgham", "67890"),
            User(firstName = "Yashar", lastName = "Jahanshahlou", userName = "piaz", "13579"),
        )

        val Categories = mutableListOf<Category>(
            Category(2, "تفریحی"),
            Category(3, "مواد غذایی"),
            Category(4, "خدماتی"),
            Category(5, "تعمیرات"),
            Category(6, "تزئینات"),
            Category(7, "نظافت"),
            Category(1, "عمومی"),
            Category(8, "کافه و رستوران"),
            Category(9, "آموزشی"),
            Category(10, "پزشکی"),
        )

        val Services = mutableListOf<Service>(
            Service(6, 8, "کافه‌ی ساحل", address = "تهران، خیابان ظفر", phone = "02188732121", 0.0, R.drawable.banner_cafe),
            Service(3, 5, "تعمیرات لپ تاپ منچستر", address = "اصفهان، خیابان ارتش", phone = "02177564432", 0.0, R.drawable.banner_laptop),
            Service(1, 4, "لوله کشی آقا بزرگ", address = "تهران، میدان نوبنیاد", phone = "02166235412", 1.0, R.drawable.banner_pipe),
            Service(2, 3, "میوه فروشی سید", address = "شیراز، خیابان شاه", phone = "02133541212", 0.0, R.drawable.banner_fruit),
            Service(8, 10, "دندان‌پزشکی بوربور", address = "تهران، میدان ونک", phone = "02177239845", 0.0, R.drawable.banner_tooth),
            Service(4, 7, "نظافت ساختمان با دانا", address = "تهران، میدان توحید", phone = "02122023454", 0.0, R.drawable.banner_clean),
            Service(5, 3, "نانوایی شاطر عباس", address = "شهرری، خیابان شهید غیوری", phone = "02144121311", 0.0, R.drawable.banner_bakery),
            Service(7, 2, "شهربازی باران", address = "تبریز، میدان ساعت", phone = "02182798721", 0.0, R.drawable.banner_eram),
        )

        val Scores = mutableListOf<Score>(
            Score("havig", 1, 2),
            Score("shalgham", 2, 4),
            Score("shalgham", 1, 3),
            Score("piaz", 3, 4),
        )

        val Comments = mutableListOf<Comment>(
            Comment("کاربر تستی", 6, "خیلی خوب بود"),
            Comment("رضا", 6, "اصلا راضی نبودم"),
            Comment("علی", 6, "حتما پیشنهاد میکنم!!"),
            Comment("عباس", 6, "عالیه"),
            Comment("کاربر تستی 2", 6, "بد نیست"),
        )
    }
}