package com.example.myfinalproject.adapters


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myfinalproject.R
import com.example.myfinalproject.databinding.ArticalItemBinding
import com.example.myfinalproject.models.Article
import com.example.myfinalproject.ui.FullScreenActivity
import com.example.myfinalproject.ui.ViewModelInterface
import com.squareup.picasso.Picasso


class NewsAdapter(private val news: List<Article>, private val context: Context, private val viewModel: ViewModelInterface):
    Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(val binding: ArticalItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val context = LayoutInflater.from(parent.context)
        val binding = ArticalItemBinding.inflate(context, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val new1 = news[position]
        var saved = false
        Log.d("tag", "news: ${news[position]}")
        with(holder.binding) {
            tvTitle.text = new1.title
            tvArticle.text = "מקור " + new1.author
            if (new1.content == null) {
                buttonMoreDetails.text = "no details"
                buttonMoreDetails.isEnabled = false
            }
            buttonMoreDetails.setOnClickListener {
                Log.d("tag", "content: ${new1.content}")
                val intent = Intent(it.context, FullScreenActivity::class.java)
                intent.putExtra("content", new1.content)
                intent.putExtra("url", new1.url)
                startActivity(it.context, intent, null)


                //    Picasso.get().load("app/src/main/res/drawable/ic_news.xml").into(ivNews)
            }
            btnIsSaved.setOnClickListener {
                if (saved) {
                    viewModel.deleteArticle(new1)
                    btnIsSaved.setImageResource(R.drawable.data_saver_off)
                }else{
                    viewModel.saveArticle(new1)
                    btnIsSaved.setImageResource(R.drawable.data_saver_on)
                }
                saved = !saved
            }

            if (new1.urlToImage == null) {
                ivNews.setImageResource(R.drawable.ic_news)
            } else {
                Picasso.get().load(new1.urlToImage).into(ivNews)
            }
            // ivNews.setImageResource(R.drawable.ic_news)
            new1.description?.let { tvArticle.text = new1.description }

        }

    }


    override fun getItemCount(): Int = news.size
}



