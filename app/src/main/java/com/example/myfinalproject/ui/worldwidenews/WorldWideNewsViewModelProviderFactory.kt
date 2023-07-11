package com.example.myfinalproject.ui.worldwidenews

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfinalproject.repository.NewsRepository

class WorldWideNewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WorldWideNewsViewModel(newsRepository) as T
    }
}
