package com.de.newsservice.restcontroller

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NewsServiceAPIRequestController(apiKey: String) {

    @SuppressLint("NewApi")
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val date: String = LocalDate.now().format(formatter)

    private var requestURI: String =
        "https://newsapi.org/v2/everything?q=Apple&from=$date&sortBy=popularity&apiKey=$apiKey"

    fun getNewsStream(): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(requestURI)
            .get()
            .addHeader("Accept", "application/json")
            .build()

        val response = client.newCall(request).execute()
        return response.body.toString()
    }

}