package com.gutsenko.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gutsenko.cleanarchitecture.domain.models.SaveUserNameParam
import com.gutsenko.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.gutsenko.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive


    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(text)
        _resultLive.value = "result = ${saveUserNameUseCase.execute(params)}"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}