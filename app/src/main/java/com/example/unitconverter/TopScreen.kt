package com.example.unitconverter

import androidx.compose.runtime.Composable

@Composable
fun TopScreen(list: List<Converter>) {
    ConversionMenu(list = list)
}