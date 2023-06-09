package com.example.myfinalproject.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myfinalproject.databinding.ArticalItemBinding
import com.squareup.picasso.Picasso
import com.example.myfinalproject.models.Article


class NewsAdapter(private val news: List<Article>) : Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(val binding: ArticalItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val context = LayoutInflater.from(parent.context)
        val binding = ArticalItemBinding.inflate(context, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val new1 = news[position]
        Log.d("tag","news: ${news[position]}")
        with(holder.binding) {
            tvTitle.text = new1.title
            new1.urlToImage?.let { Picasso.get().load(new1.urlToImage).into(ivNews)}

            new1.description?.let{tvArticle.text=new1.description}
        }
    }

    override fun getItemCount(): Int =news.size
}