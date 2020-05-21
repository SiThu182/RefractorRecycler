package com.example.refractorrecyclerview.adapter


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class InputViewModel : ViewModel() {
    private var text = MutableLiveData<InputText>()

    init {
        text = getText()
    }

    fun settext(input : InputText ){
        text.value = input
    }

    fun getText() = text


}