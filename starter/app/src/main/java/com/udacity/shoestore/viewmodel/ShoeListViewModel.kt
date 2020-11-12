package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = mutableListOf()
    }

    fun add(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    fun setTitle(title: String) {
        _title.value = title
    }
}