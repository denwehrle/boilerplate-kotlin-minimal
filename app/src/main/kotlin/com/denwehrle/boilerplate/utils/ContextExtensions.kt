package com.denwehrle.boilerplate.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * @author Dennis Wehrle
 */
fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG): Toast {
    return Toast.makeText(this, text, duration).apply { show() }
}

fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG): Toast {
    return Toast.makeText(this, resId, duration).apply { show() }
}
