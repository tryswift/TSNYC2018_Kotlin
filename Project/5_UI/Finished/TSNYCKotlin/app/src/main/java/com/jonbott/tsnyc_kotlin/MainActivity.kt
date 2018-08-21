package com.jonbott.tsnyc_kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.jonbott.tsnyc_kotlin.i_everydaykotlin.SimilaritiesActivity
import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.KotlinComparisonActivity
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayerActivity
import com.jonbott.tsnyc_kotlin.iv_Threading.ThreadingActivity
import com.jonbott.tsnyc_kotlin.v_AndroidUI.UIActivity
import kotlinx.android.synthetic.main.activity_main.*

enum class Example(val label: String) {
    Similarities("Similarities"),
    DeepDive("Differences Deep Dive"),
    DataLayer("Networking and Database"),
    Threading("Threading"),
    UI("Android UI Components"),
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupList()
    }

    private fun setupList() {
        val listItems = Example.values().map { it.label }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        activitiesListView.adapter = adapter

        activitiesListView.setOnItemClickListener { parent, view, position, id ->
            when(position) {
                Example.Similarities.ordinal -> presentSimilaritiesExample()
                Example.DeepDive.ordinal -> presentDeepDiveExample()
                Example.DataLayer.ordinal -> presentDataLayerExample()
                Example.Threading.ordinal -> presentThreadingExample()
                Example.UI.ordinal -> presentUIExample()
            }
        }
    }

    private fun presentSimilaritiesExample() {
        val intent = Intent(this, SimilaritiesActivity::class.java)
        startActivity(intent)
    }

    private fun presentDeepDiveExample() {
        val intent = Intent(this, KotlinComparisonActivity::class.java)
        startActivity(intent)
    }

    private fun presentDataLayerExample() {
        val intent = Intent(this, DataLayerActivity::class.java)
        startActivity(intent)
    }

    private fun presentThreadingExample() {
        val intent = Intent(this, ThreadingActivity::class.java)
        startActivity(intent)
    }

    private fun presentUIExample() {
        val intent = Intent(this, UIActivity::class.java)
        startActivity(intent)
    }
}