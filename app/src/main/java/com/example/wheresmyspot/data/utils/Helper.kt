package com.example.wheresmyspot.data.utils

import com.google.gson.JsonArray

fun <T : Enum<T>> toJsonArray(input: List<T>): JsonArray {
    return JsonArray().apply {
        input.forEach {
            add(it.name)
        }
    }
}