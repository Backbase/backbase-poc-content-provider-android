package com.backbase.android.cms.client.data.dto

import com.google.gson.annotations.SerializedName

/**
 * This is the custom content type created on Drupal.
 */
data class PostResponse(
    @SerializedName("data") val data: List<Data>,
    @SerializedName("included") val included: List<Included>,
)