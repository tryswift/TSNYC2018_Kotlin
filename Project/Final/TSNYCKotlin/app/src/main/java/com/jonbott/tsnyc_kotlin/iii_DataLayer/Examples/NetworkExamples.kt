package com.jonbott.tsnyc_kotlin.iii_DataLayer.Examples

import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.Entities.Article
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.NetworkInteractor
import io.reactivex.subjects.BehaviorSubject

object NetworkExamples {
    private var articleId = "2"
    private val currentArticle = BehaviorSubject.create<Article>()

    fun run() {
        currentArticle.subscribe { article ->
            article?.let { changeArticle(it) }
        }

        loadArticle(articleId)
    }

    private fun changeArticle(article: Article?) {
        if (article == null) return

        article.title = "This has changed"

        NetworkInteractor.instance.postArticle(article, this::handleChangedArticle, this::handleFailure)
    }

    private fun handleChangedArticle(newArticle: Article?) {
        if(newArticle == null) return

        println("~~~ Changed ~~~")
        println(newArticle)
    }

    private fun handleFailure() {
        println("Failed to load the currentArticle")
    }

    private fun loadArticle(articleId: String) {
        NetworkInteractor.instance.getArticle(articleId, this::handleNewArticle, this::handleFailure)
    }

    private fun handleNewArticle(newArticle: Article?) {
        if(newArticle == null) return

        println(newArticle)

        currentArticle.onNext(newArticle)
    }
}