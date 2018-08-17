package com.jonbott.tsnyc_kotlin.iv_Threading

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jonbott.tsnyc_kotlin.R

class ThreadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threading)

        runThreadingExamples()
    }

    private fun runThreadingExamples() {
//        ThreadingExample.threading_oldSchool()
//        ThreadingExample.threading_RxJava()
        ThreadingExample.threading_coroutines()
    }

    override fun onDestroy() {
        ThreadingExample.cleanUp()
    }
}
