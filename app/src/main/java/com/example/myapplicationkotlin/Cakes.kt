package com.example.myapplicationkotlin
import java.io.Serializable


data class Cakes(val image: String, val name: String, val desc: String, val prise: String):
    Serializable
