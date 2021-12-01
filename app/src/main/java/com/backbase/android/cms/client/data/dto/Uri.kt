package com.backbase.android.cms.client.data.dto
import com.google.gson.annotations.SerializedName
data class Uri (

	@SerializedName("value") val value : String,
	@SerializedName("url") val url : String
)