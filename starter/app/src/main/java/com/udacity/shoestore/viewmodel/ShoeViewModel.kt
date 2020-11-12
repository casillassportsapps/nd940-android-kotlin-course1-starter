package com.udacity.shoestore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val description = MutableLiveData<String>()

/*    val name: LiveData<String>
        get() = _name
    val company: LiveData<String>
        get() = _company
    val size: LiveData<Double>
        get() = _size
    val description: LiveData<String>
        get() = _description*/

    val shoe: Shoe
        get() = Shoe(name.value, size.value, company.value, description.value)
}