package com.example.unitconverter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TopScreen(list: List<Converter>) {
    val selectedConversion: MutableState<Converter?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(converter = it, inputText = inputText)
    }

}