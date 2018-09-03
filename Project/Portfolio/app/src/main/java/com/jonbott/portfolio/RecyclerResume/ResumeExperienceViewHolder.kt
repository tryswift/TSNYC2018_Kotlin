package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.jonbott.portfolio.R

data class JobInfo(val title: String,
                   val description: String,
                   val dateRange: String,
                   val companyText: String)

class ResumeExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context

    val cardView: CardView
    val jobTitleTextView: TextView
    val jobDescriptionTextView: TextView
    val dateRangeRextView: TextView
    val companyTextView: TextView



    init {
        cardView = itemView.findViewById(R.id.resumeExperienceCardView)
        jobTitleTextView = itemView.findViewById(R.id.jobTitleTextView)
        jobDescriptionTextView = itemView.findViewById(R.id.jobDescriptionTextView)
        dateRangeRextView = itemView.findViewById(R.id.dateRangeRextView)
        companyTextView = itemView.findViewById(R.id.companyTextView)

    }

    fun configureWith(info: JobInfo) {
        jobTitleTextView.text = info.title
        jobDescriptionTextView.text = info.description
        dateRangeRextView.text = info.dateRange
        companyTextView.text = info.companyText
    }
}