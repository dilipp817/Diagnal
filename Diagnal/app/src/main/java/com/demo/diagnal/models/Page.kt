package com.demo.diagnal.models

import com.google.gson.annotations.SerializedName

data class Page (
    @SerializedName("title") var title: String = "",
    @SerializedName("total-content-items") var totalContentItems: String = "",
    @SerializedName("page-num") var pageNum: String = "",
    @SerializedName("page-size") var pageSize: String = "",
    @SerializedName("content-items") var contentItems: ContentItems = ContentItems()

)