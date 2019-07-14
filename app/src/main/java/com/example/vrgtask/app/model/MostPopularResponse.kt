package com.example.vrgtask.app.model

import com.google.gson.annotations.SerializedName

class MostPopularResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("num_results") var numResults: Int? = null,
    @SerializedName("results") var results: List<ArticleInfo>? = null)