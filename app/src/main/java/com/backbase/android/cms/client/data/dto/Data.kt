package com.backbase.android.cms.client.data.dto

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: Attributes
)