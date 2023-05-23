package com.example.afinal.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NewsResponse
import com.example.domain.usecase.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val getNewsUseCase: GetNews) :
    ViewModel() {
    private var _moviesLiveData = MutableLiveData<NewsResponse?>()
        get() = _moviesLiveData

    private var _status = MutableLiveData<Boolean>()
        get() = _status

    fun getNews() {
        viewModelScope.launch {
            kotlin.runCatching { _moviesLiveData.postValue(getNewsUseCase()) }
                .onSuccess {
                    _status.postValue(true)
                }.onFailure {
                    _status.postValue(false)
                }

        }
    }
}