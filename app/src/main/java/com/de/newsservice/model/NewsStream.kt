package com.de.newsservice.model

data class NewsStream(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)