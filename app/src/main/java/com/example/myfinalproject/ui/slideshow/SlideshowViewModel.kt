package com.example.myfinalproject.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.repository.NewsRepository
import com.example.myfinalproject.ui.ViewModelInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SlideshowViewModel(private val newsRepository: NewsRepository) : ViewModel(),ViewModelInterface {

    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>> = _news

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _news.postValue(newsRepository.getAllNewsTech())
        }
    }
    override fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }
    override fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}