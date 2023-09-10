package com.example.samplecomposearchitecture.domain.dog.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 犬
 *
 * @property url URL
 */
@Parcelize
data class Dog(
    val url: String,
) : Parcelable
