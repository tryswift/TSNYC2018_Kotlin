package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.NetworkLayer.Helpers

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Code ServiceGenerator snippet used courtesy of Marcus Pöhls and Norman Peitek
//https://leanpub.com/retrofit-love-working-with-apis-on-android

object ServiceGenerator {
    val API_BASE_URL = "https://jsonplaceholder.typicode.com" //http://localhost:3000";

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }

    fun <S> createService(serviceClass: Class<S>, authToken: String?): S {
        if (authToken != null) {
            addRequestHeaders(authToken)
        }

        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    private fun addRequestHeaders(authToken: String?) {
        httpClient.interceptors().add(Interceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder().header("Authorization", authToken).method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        })
    }
}