package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer

import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.EndpointInterfaces.JsonPlaceHolder
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.Entities.Article
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.Helpers.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

typealias ArticleLambda = (Article?)->Unit
typealias VoidLambda    = ()->Unit

class NetworkInteractor {
    companion object { val instance = NetworkInteractor() }

    private val placeHaolderApi: JsonPlaceHolder

    init {
        placeHaolderApi = ServiceGenerator.createService(JsonPlaceHolder::class.java)
    }

    fun getArticle(articleId: String, success: ArticleLambda, failure: VoidLambda) {
        val call = placeHaolderApi.getArticle(articleId)

        call.enqueue(object: Callback<Article> {
            override fun onResponse(call: Call<Article>?, response: Response<Article>?) {
                val article = parseRespone(response)
                success(article)
            }

            override fun onFailure(call: Call<Article>?, t: Throwable?) {
                println("Failed to GET Article: ${ t?.message }")
                failure()
            }
        })
    }

    fun postArticle(article: Article, success: ArticleLambda, failure: VoidLambda) {
        val call = placeHaolderApi.putArticle(article.id, article)

        call.enqueue(object: Callback<Article>{
            override fun onResponse(call: Call<Article>?, response: Response<Article>?) {
                val article = parseRespone(response)
                success(article)
            }

            override fun onFailure(call: Call<Article>?, t: Throwable?) {
                println("Failed to POST Article: ${ t?.message }")
                failure()
            }
        })
    }

    private fun parseRespone(response: Response<Article>?): Article? {
        val article = response?.body() ?: null

        if (article == null) {
            parseResponeError(response)
        }

        return article
    }

    private fun parseResponeError(response: Response<Article>?) {
        if(response == null) return

        val responseBody = response.errorBody()

        if(responseBody != null) {
            try {
                val text = "responseBody = ${ responseBody.string() }"
                println("$text")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            val text = "responseBody == null"
            println("$text")
        }
    }
}