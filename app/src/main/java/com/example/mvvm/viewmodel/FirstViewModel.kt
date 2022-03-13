package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private var _number = MutableLiveData<Int>()
    val number : LiveData<Int>
        get() = _number

    fun increaseTheNumber(no : Int){
        _number.value = no + 1
    }

}