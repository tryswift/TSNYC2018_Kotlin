package com.jonbott.portfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jonbott.portfolio.RecyclerResume.Header
import com.jonbott.portfolio.RecyclerResume.ResumeHeaderViewAdapter
import kotlinx.android.synthetic.main.activity_main.*


data class MyInfo(val people: List<Person>)
data class Person(var name: String, var age: Int)

class MainActivity : AppCompatActivity() {

    lateinit var headerAdapter: ResumeHeaderViewAdapter

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
        val fakeHeader = Header("profile.jpg", "some name", "some@email.com", "(111) 222-3333", "@Cool Guy")
        headerAdapter = ResumeHeaderViewAdapter(fakeHeader) { view, position -> rowTapped(position)}
        resumeRecyclerView.adapter = headerAdapter
    }

    private fun rowTapped(position: Int) {
        println("rowTapped: $position")
    }
}
