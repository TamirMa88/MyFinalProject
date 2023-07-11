package com.example.myfinalproject.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinalproject.models.Article
import kotlinx.coroutines.launch
import com.example.myfinalproject.repository.NewsRepository

class WorldWideNewsViewModel (val newsRepository: NewsRepository): ViewModel() {

        private val _news: MutableLiveData<List<Article>> = MutableLiveData()
        val news: LiveData<List<Article>> = _news

    init {
        viewModelScope.launch {
            _news.postValue(newsRepository.getAllNewsWorldWide())
        }

    }

}