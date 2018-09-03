package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.jonbott.portfolio.R

class ResumeGeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context

    val cardView: CardView
    val generalTextView: TextView

    init {
        cardView = itemView.findViewById(R.id.generalCellCardView)
        generalTextView = itemView.findViewById(R.id.generalTextView)
    }

    fun configureWith(info: String) {
        generalTextView.text = info
    }
}

