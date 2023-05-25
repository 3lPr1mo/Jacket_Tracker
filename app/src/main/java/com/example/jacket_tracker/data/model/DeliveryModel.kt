package com.example.jacket_tracker.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class DeliveryModel(
    @SerializedName("id") var id: String,
    @SerializedName("date") var date: Date,
    @SerializedName("user") var user: UserModel,
    @SerializedName("jacket") var jacket: JacketModel
    )
