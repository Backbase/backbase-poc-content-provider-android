package com.backbase.android.cms.client.ui.post.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val title: String,
    val desc: String,
    val imageUrl: String,
) : Parcelable