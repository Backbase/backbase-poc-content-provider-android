package com.backbase.android.cms.client.utils

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Extension function that helps basic html content
 */
fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }
}