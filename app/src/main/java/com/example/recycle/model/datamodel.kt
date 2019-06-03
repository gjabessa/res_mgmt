package com.example.recycle.model

import java.io.Serializable

data class DataModel(
    val id: String,
    val image: String,
    val name: String,
    val description: String,
    val price: Int,
    val image_large: String
): Serializable