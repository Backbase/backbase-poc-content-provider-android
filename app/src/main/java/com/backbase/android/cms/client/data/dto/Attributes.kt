package com.backbase.android.cms.client.data.dto

import com.google.gson.annotations.SerializedName


data class Attributes(

    @SerializedName("field_description") val field_description: String,
    @SerializedName("title") val title: String,
    @SerializedName("uri") val uri: Uri,
)