package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jonbott.androidui.Helpers.ImageHelper
import com.jonbott.portfolio.R
import com.jonbott.portfolio.RecyclerResume.Entities.ResumeHeader


class ResumeHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context

    val cardView: CardView
    val imageView: ImageView
    val nameTextView: TextView
    val emailTextView: TextView
    val phoneTextView: TextView
    val handleTextView: TextView

    init {
        cardView = itemView.findViewById(R.id.headerCardView)
        imageView = itemView.findViewById(R.id.imageView)
        nameTextView = itemView.findViewById(R.id.nameTextView)
        emailTextView = itemView.findViewById(R.id.emailTextView)
        phoneTextView = itemView.findViewById(R.id.phoneTextView)
        handleTextView = itemView.findViewById(R.id.handleTextView)
    }

    fun configureWith(resumeHeader: ResumeHeader) {
        nameTextView.text = resumeHeader.nameText
        emailTextView.text = resumeHeader.emailText
        phoneTextView.text = resumeHeader.phoneText
        handleTextView.text = resumeHeader.handleText

        val imageId = ImageHelper.resourceIdWith(context, resumeHeader.imageName)
        if (imageId != 0) {
            imageView.setImageResource(imageId)
        }
    }
}

