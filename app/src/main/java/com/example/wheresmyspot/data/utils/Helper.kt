package com.example.wheresmyspot.data.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.gson.JsonArray
import androidx.core.graphics.createBitmap

fun <T : Enum<T>> toJsonArray(input: List<T>): JsonArray {
    return JsonArray().apply {
        input.forEach {
            add(it.name)
        }
    }
}

fun vectorToBitmap(
    context: Context,
    @DrawableRes drawableId: Int
): Bitmap {
    val drawable = ContextCompat.getDrawable(context, drawableId)
        ?: throw IllegalArgumentException("Drawable not found")

    val bitmap = createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight)

    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)

    return bitmap

}