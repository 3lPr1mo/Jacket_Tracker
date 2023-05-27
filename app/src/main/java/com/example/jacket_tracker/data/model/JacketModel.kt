package com.example.jacket_tracker.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class JacketModel(
    @SerializedName("id") var id: String,
    @SerializedName("description") var description: String,
    @SerializedName("size") var size: String,
    @SerializedName("price") var price: Int,
    @SerializedName("quantityDelivered") var quantityDelivered: Int,
    @SerializedName("deliveryDate") var deliveryDate: String,
    @SerializedName("jacketCategory") var jacketCategory: String
)
