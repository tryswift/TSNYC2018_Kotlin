package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jonbott.portfolio.R

class ResumeGeneralViewAdapter(var info: String) : RecyclerView.Adapter<ResumeHeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeHeaderViewHolder {
        val headerView = LayoutInflater.from(parent.context).inflate(R.layout.cell_general_text, parent, false)
        val viewHolder = ResumeHeaderViewHolder(headerView)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ResumeGeneralViewHolder, position: Int) {
        holder.configureWith(info)
    }

    override fun getItemCount(): Int = 1
}