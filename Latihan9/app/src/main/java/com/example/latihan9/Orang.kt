package com.example.latihan9

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Orang(
    val nama: String?,
    val game: String?
) : Parcelable


