package com.example.jacket_tracker.model

import java.util.Date

data class JacketModel(
    var id: String,
    var description: String,
    var size: String,
    var price: Int,
    var quantityDelivered: Int,
    var deliveryDate: Date,
    var jacketCategory: String
)
