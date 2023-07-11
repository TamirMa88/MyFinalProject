package com.example.myfinalproject.ui.slideshow

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfinalproject.repository.NewsRepository

class SlideshowViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SlideshowViewModel(newsRepository) as T
    }
}
