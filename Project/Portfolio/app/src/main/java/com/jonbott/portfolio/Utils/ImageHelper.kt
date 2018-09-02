package com.jonbott.androidui.Helpers

import android.content.Context

object ImageHelper {
    fun resourceIdWith(context: Context, imageName: String): Int {
        val res = context.resources
        return res.getIdentifier(imageName, "drawable", context.packageName)
    }
}