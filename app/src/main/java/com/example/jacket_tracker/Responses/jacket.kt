package com.example.jacket_tracker.Responses

data class jacket(
    val id: Int,
    val description: String,
    val size: String,
    val price: Int,
    val quantityDeliveried: Int,
    val deliveryDate: String
)