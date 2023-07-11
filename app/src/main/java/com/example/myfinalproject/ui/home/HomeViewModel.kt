package com.example.myfinalproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.repository.NewsRepository
import com.example.myfinalproject.ui.ViewModelInterface
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel(), ViewModelInterface {

    // val news : List<Article> = NewService.create().techNews().articles

    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>> = _news

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _news.postValue(newsRepository.getNews())
        }
    }
    override fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }
    override fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}