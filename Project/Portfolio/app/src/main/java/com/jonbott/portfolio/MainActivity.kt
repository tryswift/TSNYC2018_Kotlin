package com.jonbott.portfolio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jonbott.portfolio.RecyclerResume.Entities.ResumeHeader
import com.jonbott.portfolio.RecyclerResume.JobInfo
import com.jonbott.portfolio.RecyclerResume.ResumeViewAdapter
import kotlinx.android.synthetic.main.activity_main.*


data class MyInfo(val people: List<Person>)
data class Person(var name: String, var age: Int)

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ResumeViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = resources.openRawResource(R.raw.my_json)
        val people = Gson().fromJson(inputStream.bufferedReader(), MyInfo::class.java)

        println("🦄 people: $people")

        attachUI()
    }

    private fun attachUI() {
        resumeRecyclerView.setHasFixedSize(true)
        resumeRecyclerView.layoutManager = LinearLayoutManager(this)
        resumeRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        initializeListView()
    }

    private fun initializeListView() {
        val fakeHeader = ResumeHeader("profile.jpg", "some name", "some@email.com", "(111) 222-3333", "@Cool Guy")

        val summary = "I have a large range of experience from front-end development (iOS, Android, Web) to back-end, both in large-scale commercial apps and educational apps. I have worked with media creation (video, audio), as well as developed on platforms for streaming and consuming that media. I am also a professional photographer (weddings, portraits, non-profits, events, & travel)."
        val currentWork = listOf(JobInfo("TITLE", "DESC", "Start End", "Some Company"))
        val previousWork = listOf(JobInfo("TITLE2", "DESC2", "Start End2", "Some Company2"))
        adapter = ResumeViewAdapter(fakeHeader, summary, currentWork, previousWork) { view, position -> rowTapped(position)}

        resumeRecyclerView.adapter = adapter
    }

    private fun rowTapped(position: Int) {
        println("rowTapped: $position")
    }
}
