package com.jonbott.tsnyc_kotlin.v_AndroidUI.Recycler

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jonbott.Utils.Spy
import com.jonbott.androidui.Helpers.ImageHelper
import com.jonbott.tsnyc_kotlin.R

class SpyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val context = itemView.context

    val cardView: CardView
    val personName: TextView
    val personAge: TextView
    val personPhoto: ImageView

    init {
        cardView    = itemView.findViewById(R.id.cardView)
        personName  = itemView.findViewById(R.id.nameTextView)
        personAge   = itemView.findViewById(R.id.ageTextView)
        personPhoto = itemView.findViewById(R.id.profileImage)
    }

    fun configureWith(spy: Spy) {
        personName.text = spy.name
        personAge.text  = spy.age.toString()

        val imageId = ImageHelper.resourceIdWith(context, spy.imageName)
        if(imageId != 0) {
            personPhoto.setImageResource(imageId)
        }
    }
}