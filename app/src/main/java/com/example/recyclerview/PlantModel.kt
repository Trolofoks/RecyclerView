package com.example.recyclerview

import java.io.Serializable

data class PlantModel(
    val imageId: Int,
    val title: String,
    val description: String
    ) : Serializable
