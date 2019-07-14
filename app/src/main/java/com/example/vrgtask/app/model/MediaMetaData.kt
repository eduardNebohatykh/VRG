package com.example.vrgtask.app.model

import com.google.gson.annotations.SerializedName

data class MediaMetaData(
    @SerializedName("url") var url: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("width") var width: Int? = null)




