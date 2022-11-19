package com.demo.diagnal.models

import com.google.gson.annotations.SerializedName


data class MovieData(
    @SerializedName("page") var page: Page = Page()
)