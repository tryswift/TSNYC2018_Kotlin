package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.EndpointInterfaces

import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.Entities.Article
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolder {
    @GET("/posts/{articleId}")
    fun getArticle(@Path("articleId") articleId: String): Call<Article>

    @PUT("/posts/{articleId}")
    fun putArticle(@Path("articleId") articleId: Int, @Body article: Article): Call<Article>
}