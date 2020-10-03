package com.example.pagingnewsmentoring.datasource

import androidx.paging.PageKeyedDataSource
import com.example.pagingnewsmentoring.model.ArticlesItem
import com.example.pagingnewsmentoring.network.NewsService
import com.example.pagingnewsmentoring.network.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsDataSource : PageKeyedDataSource<Long, ArticlesItem>() {

    var api : NewsService

    init {
        api = RestApi.restApi()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ArticlesItem>
    ) {
        api.getNews("Movie", "bc87b3f22459491d92ecb92ea2d79be0", 1, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.articles?.let { callback.onResult(it, null, 2L) }
            }, {

            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {
        api.getNews("Movie", "bc87b3f22459491d92ecb92ea2d79be0", params.key, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.articles?.let { callback.onResult(it,  params.key + 1L) }
            }, {

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ArticlesItem>) {

    }
}