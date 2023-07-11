package com.example.myfinalproject.ui.worldwidenews


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfinalproject.adapters.NewsAdapter
import com.example.myfinalproject.databinding.FragmentWorldwideBinding
import com.example.myfinalproject.db.ArticleDatabase
import com.example.myfinalproject.repository.NewsRepository


class WorldWideNewsFragment : Fragment() {

    private var _binding: FragmentWorldwideBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var worldWideNewsViewModel: WorldWideNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorldwideBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
        val viewModelProviderFactory = WorldWideNewsViewModelProviderFactory(newsRepository)
        worldWideNewsViewModel = ViewModelProvider(this, viewModelProviderFactory)[WorldWideNewsViewModel::class.java]

       // val textView: TextView = binding.textGallery
      //  galleryViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
       // }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvWorldWideNews.layoutManager = LinearLayoutManager(requireContext())

        worldWideNewsViewModel.news.observe(viewLifecycleOwner) {
            binding.rvWorldWideNews.adapter = NewsAdapter(it,requireContext(),worldWideNewsViewModel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}