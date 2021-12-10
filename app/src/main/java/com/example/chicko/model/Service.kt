package com.example.chicko.model

import androidx.annotation.DrawableRes

class Service(
    val ID: Int,
    val categoryID: Int,
    val name: String,
    val address: String,
    val phone: String,
    val score: Double,
    @DrawableRes val banner: Int
) {
}