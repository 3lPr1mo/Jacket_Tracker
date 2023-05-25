package com.example.jacket_tracker.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    var firstname: String,
    var lastname: String,
    var id: Int,
    var password: String,
    var email: String
    )
