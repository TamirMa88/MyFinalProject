package com.example.myfinalproject.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfinalproject.adapters.NewsAdapter
import com.example.myfinalproject.databinding.FragmentTechNewsBinding
import com.example.myfinalproject.db.ArticleDatabase
import com.example.myfinalproject.repository.NewsRepository


class HomeFragment : Fragment() {

    private var _binding: FragmentTechNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTechNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = HomeViewModelProviderFactory(newsRepository)
        homeViewModel = ViewModelProvider(this, viewModelProviderFactory)[HomeViewModel::class.java]

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTechNews.layoutManager=LinearLayoutManager(requireContext())

        homeViewModel.news.observe(viewLifecycleOwner) {
            binding.rvTechNews.adapter = NewsAdapter(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

