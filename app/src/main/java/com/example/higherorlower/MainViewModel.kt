package com.example.higherorlower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var randomLiveData = MutableLiveData<Int>()

    init {
        getNewRandom()
    }

    fun getNewRandom() {
        randomLiveData.value = (1..20).random()
    }
}