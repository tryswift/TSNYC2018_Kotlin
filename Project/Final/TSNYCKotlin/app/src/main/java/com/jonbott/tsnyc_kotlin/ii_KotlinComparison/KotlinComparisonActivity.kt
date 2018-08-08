package com.jonbott.tsnyc_kotlin.ii_KotlinComparison

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jonbott.tsnyc_kotlin.ii_KotlinComparison.Examples.Examples
import com.jonbott.tsnyc_kotlin.R

class KotlinComparisonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_comparison)

        Examples.run()
    }
}
