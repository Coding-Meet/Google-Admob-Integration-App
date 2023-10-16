package com.coding.googleadmobintegrationapp.models

data class Product(
    val id: Int,
    val title: String,
    val image: String,
    val rating: Rating,
    val price: Double
)
