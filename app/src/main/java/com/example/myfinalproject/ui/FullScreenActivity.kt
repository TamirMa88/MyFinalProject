package com.example.myfinalproject.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfinalproject.R
import com.example.myfinalproject.databinding.ActivityFullScreenBinding
import com.example.myfinalproject.databinding.ActivityMainBinding

class FullScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.text=intent.getStringExtra("content")
        binding.btFullArticle.setOnClickListener {
            val uri = Uri.parse(intent.getStringExtra("url"))
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}