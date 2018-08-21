package com.jonbott.tsnyc_kotlin.iii_DataLayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jonbott.tsnyc_kotlin.iii_DataLayer.Examples.NetworkExamples
import com.jonbott.tsnyc_kotlin.R
import com.jonbott.tsnyc_kotlin.iii_DataLayer.Examples.RoomDatabaseExamples
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_data_layer.*

class DataLayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_layer)

        runExamples()
    }

    private fun runExamples() {
        NetworkExamples.run()
        RoomDatabaseExamples.run()

        loadImage()
    }

    private fun loadImage() {
        val imageUrl = "https://picsum.photos/200/200?image=0&gravity=center"

        Picasso.get()
                .load(imageUrl)
                .resize(200, 200)
                .centerCrop()
                .into(imageView)
    }
}
