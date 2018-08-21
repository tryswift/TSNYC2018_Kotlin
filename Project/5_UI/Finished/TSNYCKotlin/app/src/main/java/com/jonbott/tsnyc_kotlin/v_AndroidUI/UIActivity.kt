package com.jonbott.tsnyc_kotlin.v_AndroidUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.jonbott.tsnyc_kotlin.R
import com.jonbott.tsnyc_kotlin.v_AndroidUI.Recycler.SpyListActivity
import kotlinx.android.synthetic.main.activity_android_ui2.*

class UIActivity : AppCompatActivity() {

    val colors = listOf("Red", "Orange", "Yellow", "Blue", "Indigo", "Violet")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_ui2)

        setupUIEvents()
    }

    private fun setupUIEvents() {

        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SpyListActivity::class.java)
            startActivity(intent)
        }

        largeTextView.text = "Some important text"

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(adapterView: AdapterView<*>?) {}

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                println("color: ${colors[position]}, id: $id")
            }
        }


        setupOtherEvents()
    }

    fun setupOtherEvents() {
        radioGroup.setOnCheckedChangeListener { radioGroup, index ->
            val selectedId = radioGroup.checkedRadioButtonId
            val colorRadioButton = findViewById<RadioButton>(selectedId)
            val color = colorRadioButton.text.toString()
            println("Color selected: $color")
        }

        checkedTextView.setOnClickListener {
            println("checkedTextView changed: ${ checkedTextView.isChecked }")
        }

        progressBarCircular.progress = 99
        progressBarLinear.progress = 22

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var progress = 0

            override fun onProgressChanged(seekBar: SeekBar, progressValue: Int, isFromUser: Boolean) {
                progress = progressValue
                progressBarLinear.progress = progress
                println("progress changed: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                println("Starting to change")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                println("Stopped changing: $progress / ${seekBar?.max}")

                Toast.makeText(applicationContext, "progress changed: $progress", Toast.LENGTH_LONG).show()
            }

        })

        imageView.setImageResource(R.drawable.adamsmith)

        imageButton.setImageResource(R.drawable.adamsmith)
        imageButton.setOnClickListener {
            Toast.makeText(applicationContext, "Image Button clicked", Toast.LENGTH_LONG).show()
        }

        switchControl.isChecked = true
        switchControl.setOnCheckedChangeListener { compoundButton, isChecked ->
            println("switchControl.isChecked: ${ switchControl.isChecked }")
        }
    }
}
