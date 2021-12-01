package com.backbase.android.cms.client.utils

import android.widget.ImageView
import com.backbase.android.cms.client.BuildConfig
import com.bumptech.glide.Glide
/**
 * Extension function that helps load image from url
 */
fun ImageView.loadFromUrl(url: String) {
    val fullUri = "${BuildConfig.API_URL}$url"
    Glide.with(this).load(fullUri).into(this);
}
