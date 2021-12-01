package com.backbase.android.cms.client.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Nested model class from Drupal, it holds type of node, the id of the entity and additional attributes
 */
data class Data(
    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: Attributes
)