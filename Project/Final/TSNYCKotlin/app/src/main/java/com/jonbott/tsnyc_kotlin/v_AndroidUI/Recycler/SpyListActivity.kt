package com.jonbott.tsnyc_kotlin.v_AndroidUI.Recycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.jonbott.androidui.Helpers.SpyCreator
import com.jonbott.tsnyc_kotlin.R
import kotlinx.android.synthetic.main.activity_spy_list.*

class SpyListActivity : AppCompatActivity() {

    lateinit var adapter: SpyViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spy_list)

        attachUI()
    }

    private fun attachUI() {
        val manager = LinearLayoutManager(this)
        spyRecylerView.setHasFixedSize(true)

        spyRecylerView.layoutManager = manager
        spyRecylerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        initializeListView()

        addSpyButton.setOnClickListener {
            addNewSpy()
        }
    }

    private fun initializeListView() {
        adapter = SpyViewAdapter { view, postion -> rowTapped(postion) }
        spyRecylerView.adapter = adapter
    }

    private fun rowTapped(postion: Int) {
        println(adapter.spies[postion])
    }

    private fun addNewSpy() {
        val spy = SpyCreator.next()
        adapter.addSpy(spy)
    }
}
