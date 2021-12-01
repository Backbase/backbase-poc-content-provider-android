package com.backbase.android.cms.client.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Nested model class from Drupal.
 * Adding query param to drupal request generates this class
 * example:Adding the query param ?include=field_image_url to the endpoint will generate this class in the response
 */
data class Included(

    @SerializedName("type") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: Attributes,
)