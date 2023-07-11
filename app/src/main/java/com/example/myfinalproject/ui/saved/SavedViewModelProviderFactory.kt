package com.example.myfinalproject.ui.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfinalproject.repository.NewsRepository

class SavedViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SavedViewModel(newsRepository) as T
    }
}
