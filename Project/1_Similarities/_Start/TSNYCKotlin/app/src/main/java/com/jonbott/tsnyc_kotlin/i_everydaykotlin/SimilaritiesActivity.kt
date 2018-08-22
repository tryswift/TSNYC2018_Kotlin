package com.jonbott.tsnyc_kotlin.i_everydaykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jonbott.tsnyc_kotlin.R

class SimilaritiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_similarities)


        runChallenge()
    }

    private fun runChallenge() {
        val names = listOf("Schultz", "Cuevas", "Rhodes", "Mckenzie", "Taylor", "Glenn", "Reilly", "Morris", "Herman", "Beltran", "Swanson", "Roth")
    }
}
