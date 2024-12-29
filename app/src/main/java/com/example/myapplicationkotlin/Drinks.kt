package com.example.myapplicationkotlin

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drinks(val image: String, val name: String, val desc: String, val prise: String):
    Parcelable
