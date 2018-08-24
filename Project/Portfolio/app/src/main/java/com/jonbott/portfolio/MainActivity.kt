package com.jonbott.portfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson


data class MyInfo(val people: List<Person>)
data class Person(var name: String, var age: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = resources.openRawResource(R.raw.my_json)
        val people = Gson().fromJson(inputStream.bufferedReader(), MyInfo::class.java)

        println("🦄 people: $people")
    }
}
