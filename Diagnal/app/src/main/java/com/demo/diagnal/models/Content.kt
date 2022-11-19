package com.demo.diagnal.models

import com.google.gson.annotations.SerializedName

data class Content (
    @SerializedName("name") var name: String = "",
    @SerializedName("poster-image") var posterImage : String = ""

)
