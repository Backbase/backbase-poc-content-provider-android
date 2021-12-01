package com.backbase.android.cms.client.data.dto
import com.google.gson.annotations.SerializedName
/**
 * Holds the reference to attached files or images
 */
data class Uri (

	@SerializedName("value") val value : String,
	@SerializedName("url") val url : String
)