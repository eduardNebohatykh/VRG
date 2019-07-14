package com.example.vrgtask.app.model

import com.google.gson.annotations.SerializedName

data class ArticleInfo(
    @SerializedName("url") var url: String? = null,
    @SerializedName("adx_keywords") var adxKeywords: String? = null,
    @SerializedName("subsection") var subsection: String? = null,
    @SerializedName("email_count") var emailCount: Int? = null,
    @SerializedName("count_type") var countType: String? = null,
    @SerializedName("column") var column: String? = null,
    @SerializedName("eta_id") var etaId: Int? = null,
    @SerializedName("section") var section: String? = null,
    @SerializedName("id") var id: Long? = null,
    @SerializedName("asset_id") var assetId: Long? = null,
    @SerializedName("nytdsection") var nytdsection: String? = null,
    @SerializedName("byline") var byline: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("abstract") var _abstract: String? = null,
    @SerializedName("published_date") var publishedDate: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("updated") var updated: String? = null,
    //Facet fields cannot be empty string
    @SerializedName("des_facet") var desFacet: List<String>? = null,
    @SerializedName("org_facet") var orgFacet: List<String>? = null,
    @SerializedName("per_facet") var perFacet: List<String>? = null,
    @SerializedName("geo_facet") var geoFacet: List<String>? = null,
    @SerializedName("media") var media: List<Media>? = null,
    @SerializedName("uri") var uri: String? = null)