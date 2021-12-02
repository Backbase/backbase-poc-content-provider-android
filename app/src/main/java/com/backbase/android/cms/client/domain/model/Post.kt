package com.backbase.android.cms.client.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/**
 * This is a custom UI class it is used to populate the data from CMS response into one class
 */
@Parcelize
data class Post(
    val title: String,
    val desc: String,
    val imageUrl: String,
) : Parcelable