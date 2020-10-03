package com.example.pagingnewsmentoring.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pagingnewsmentoring.datasource.factory.NewsDataFactory
import com.example.pagingnewsmentoring.model.ArticlesItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsViewModel : ViewModel() {

    var executor : Executor
    var articleData : LiveData<PagedList<ArticlesItem>>

    init {
        executor = Executors.newFixedThreadPool(5)
        var newsFactory = NewsDataFactory()
        var pagedListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        articleData = LivePagedListBuilder(newsFactory, pagedListConfig)
            .setFetchExecutor(executor)
            .build()
    }

    fun getArticle() : LiveData<PagedList<ArticlesItem>> {
        return getArticle()
    }

}