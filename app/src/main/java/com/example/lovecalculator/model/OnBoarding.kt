package com.example.lovecalculator.model

import java.io.Serializable

data class OnBoarding(
    val image: Int? = null,
    val title: String? = null,
    val description: String? = null
) : Serializable