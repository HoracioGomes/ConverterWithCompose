package com.example.unitconverter

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.unitconverter.ui.theme.ResultBlock
import java.math.RoundingMode
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopScreen(list: List<Converter>) {
    val selectedConversion: MutableState<Converter?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    val typedText = remember { mutableStateOf("0.0") }
    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(converter = it, inputText = inputText) { text ->
            typedText.value = text
        }
    }

    if (typedText.value != "0.0") {
        val value = typedText.value.toDouble()
        val multiply = selectedConversion.value?.multiplyBy ?: 0.0
        val result = value * multiply

        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${inputText.value} ${selectedConversion.value?.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value?.convertTo}"

        ResultBlock(message1 = message1, message2 = message2)
    }

}