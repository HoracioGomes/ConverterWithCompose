package com.example.unitconverter

import androidx.lifecycle.ViewModel

class ConverterViewModel: ViewModel() {

    fun getConversions() = listOf(
        Converter(1,"Pounds to Kilograms","lbs","kg",0.453592),
        Converter(2,"Kilograms to Pounds","kg","lbs",2.20462),
        Converter(3,"Yards to Meters","yd","m",0.9144),
        Converter(4,"Meters to Yards","m","yd",1.09361),
        Converter(5,"Miles to Kilometers","mi","km",1.60934),
        Converter(6,"Kilometers to Miles","km","mi",0.621371)
    )
}