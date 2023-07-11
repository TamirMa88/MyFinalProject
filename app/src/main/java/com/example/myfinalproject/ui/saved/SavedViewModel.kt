package com.example.myfinalproject.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.repository.NewsRepository
import com.example.myfinalproject.ui.ViewModelInterface
import kotlinx.coroutines.Dispatchers

class SavedViewModel(private val newsRepository: NewsRepository) : ViewModel(),ViewModelInterface {


    private val _news: MutableLiveData<List<Article>> = MutableLiveData()
    val news: LiveData<List<Article>> = _news

   fun getSavedArticles(){
       viewModelScope.launch(Dispatchers.IO) {
           _news.postValue(newsRepository.getSavedNews())
       }
   }
    override fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }
    override fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}