package com.example.pagingnewsmentoring.network

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestApi {

    companion object {
        fun restApi(): NewsService {

            val baseUrl = "http://newsapi.org/v2/"

            //Step 1 configurasi interceptor
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttp = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            //Step yang ke 2
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            //Step yang ke 3
            return retrofit.create(
                NewsService::
                class.java
            )

        }
    }

}