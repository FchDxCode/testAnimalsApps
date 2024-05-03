package com.example.animals_apps.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.animals_apps.ui.theme.mainColor

data class Header(
    val title: String,
    val titleColor: Color = mainColor,
    val titleFont: FontFamily,
    val logoResId: Int
)
