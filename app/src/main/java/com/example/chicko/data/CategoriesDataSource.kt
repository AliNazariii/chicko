package com.example.chicko.data

class CategoriesDataSource {

    fun loadCategories(): List<CategoryData> {
        return Database.Categories.map { category -> CategoryData(category.name) }
    }
}

data class CategoryData(
    val label: String
)