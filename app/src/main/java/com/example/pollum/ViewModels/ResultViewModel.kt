package com.example.pollum.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pollum.network.ApiConfig
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ResultViewModel : ViewModel() {
    val scanResult: MutableLiveData<String> = MutableLiveData()

    fun scanBeeImage(photoFilePath: String?) {
        val file = File(photoFilePath)
        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("image", file.name, requestFile)

        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().scanBeeImage(imagePart)
                scanResult.value = response.result
            } catch (e: Exception) {
                // Handle the exception
            }

        }
    }
}





