package com.example.consumingdatawithrecyclerview.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumingdatawithrecyclerview.network.Image
import com.example.consumingdatawithrecyclerview.network.ImageGalleryApi
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel: ViewModel(){

    private val _image = MutableLiveData<Image>()
    val image: LiveData<Image> = _image

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    init {
        getGalleryImages()
    }

    private fun getGalleryImages(){

        viewModelScope.launch {
            try {
                val listResult = ImageGalleryApi.retrofitService.getGalleryImages()
                _response.value = "Success: Image gallery return ${listResult.size} images."
                if(listResult.size > 0 ){
                    _image.value = listResult[0]
                }
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}