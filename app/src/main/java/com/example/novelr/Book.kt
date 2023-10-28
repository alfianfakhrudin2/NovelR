package com.example.novelr

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book (
    val name: String,
    val deskripsi: String,
    val foto: Int,
    val genre: String,
    val penerbit: String,
    val bahasa: String
) : Parcelable