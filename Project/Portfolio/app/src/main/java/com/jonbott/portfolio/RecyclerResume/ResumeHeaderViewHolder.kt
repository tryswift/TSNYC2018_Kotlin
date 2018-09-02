package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jonbott.androidui.Helpers.ImageHelper
import com.jonbott.portfolio.R

data class Header(
        val imageName: String,
        val nameText: String,
        val emailText: String,
        val phoneText: String,
        val handleText: String
)


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

    fun configureWith(header: Header) {
        nameTextView.text = header.nameText
        emailTextView.text = header.emailText
        phoneTextView.text = header.phoneText
        handleTextView.text = header.handleText

        val imageId = ImageHelper.resourceIdWith(context, header.imageName)
        if (imageId != 0) {
            imageView.setImageResource(imageId)
        }
    }
}

