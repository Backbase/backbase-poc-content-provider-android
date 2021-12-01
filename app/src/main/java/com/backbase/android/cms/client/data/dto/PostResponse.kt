
package com.backbase.android.cms.client.data.dto
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("data") val data: List<Data>,
    @SerializedName("included") val included: List<Included>,
)