package com.example.chicko.data

import com.example.chicko.model.Category

class CategoriesDataSource {

    companion object {
        fun getCategoryById(id: Int): Category? {
            return Database.Categories.find { it.ID == id }
        }
    }

    fun loadCategories(): List<CategoryData> {
        return Database.Categories.map { category -> CategoryData(category.ID, category.name) }
    }
}

data class CategoryData(
    val id: Int,
    val label: String
)