package com.devillas.daggerhiltandretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devillas.daggerhiltandretrofit.model.ImageItems
import com.devillas.daggerhiltandretrofit.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val repository: ImageRepository): ViewModel() {
    private val _response = MutableLiveData<List<ImageItems>>()
    val responseImage :LiveData<List<ImageItems>>
    get() = _response

    init {
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch {

        repository.getAllImage().let {response ->
        if (response.isSuccessful){
            _response.postValue(response.body())
        }    else {
            Log.d("yourTage","getAllImage Error :${response.errorBody()}")
        }
        }
    }
}