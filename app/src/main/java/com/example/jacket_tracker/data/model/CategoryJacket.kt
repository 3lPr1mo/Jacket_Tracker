package com.example.jacket_tracker.data.model

import com.google.gson.annotations.SerializedName

data class CategoryJacket(
    @SerializedName("id") var id: Int,
    @SerializedName("type") var type: String
    )
