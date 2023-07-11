package com.example.myfinalproject.ui.saved


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfinalproject.adapters.NewsAdapter
import com.example.myfinalproject.databinding.FragmentSavedNewsBinding
import com.example.myfinalproject.db.ArticleDatabase
import com.example.myfinalproject.repository.NewsRepository


class SavedFragment : Fragment() {

    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var savedViewModel: SavedViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = SavedViewModelProviderFactory(newsRepository)
        savedViewModel = ViewModelProvider(this, viewModelProviderFactory)[SavedViewModel::class.java]

        return root
    }

    override fun onResume() {
        super.onResume()
        savedViewModel.getSavedArticles()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())

        savedViewModel.news.observe(viewLifecycleOwner) {
            binding.rvNews.adapter = NewsAdapter(it, requireContext(),savedViewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
