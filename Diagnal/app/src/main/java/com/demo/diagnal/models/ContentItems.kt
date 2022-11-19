package com.demo.diagnal.models

import com.google.gson.annotations.SerializedName

data class ContentItems (

@SerializedName("content") var content : List<Content> = emptyList()

)
