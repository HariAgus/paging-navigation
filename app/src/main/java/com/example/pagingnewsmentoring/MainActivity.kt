package com.example.pagingnewsmentoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.pagingnewsmentoring.adapter.NewslistAdapter
import com.example.pagingnewsmentoring.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel : NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel?.getArticle()?.observe(this, Observer {
            val adapter = NewslistAdapter()
            adapter.submitList(it)
            listNews.adapter = adapter
        })

    }
}