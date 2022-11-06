package com.de.newsservice.mapper

import com.de.newsservice.model.NewsStream
import com.de.newsservice.restcontroller.NewsServiceAPIRequestController
import com.google.gson.Gson

class NewsStreamMapper {
    fun getNewsStream(apiKey: String): NewsStream {
        val newsServiceAPIRequestController = NewsServiceAPIRequestController(apiKey)
        val json = newsServiceAPIRequestController.getNewsStream()
        return Gson().fromJson(json, NewsStream::class.java)
    }
}