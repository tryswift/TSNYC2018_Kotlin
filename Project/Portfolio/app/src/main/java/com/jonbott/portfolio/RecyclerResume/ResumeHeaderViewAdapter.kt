package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jonbott.portfolio.R

typealias ItemClickLambda = (v: View, position: Int)->Unit

enum class CellTypes {
    HEADER,
    GENERAL,
    EXPERIENCE
}


class ResumeHeaderViewAdapter(var header: Header, var info: String, var onItemClick: ItemClickLambda) : RecyclerView.Adapter<ResumeHeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeHeaderViewHolder {
        val headerView = LayoutInflater.from(parent.context).inflate(R.layout.cell_resume_header, parent, false)

        val cellType = CellTypes.values()[viewType]

        when (cellType) {
            CellTypes.HEADER -> {
                val viewHolder = ResumeHeaderViewHolder(headerView)
                headerView.setOnClickListener { v -> onItemClick(v, viewHolder.adapterPosition) }

                return viewHolder
            }

                CellTypes.GENERAL, CellTypes.EXPERIENCE ->
        }
    }

    override fun onBindViewHolder(holder: ResumeHeaderViewHolder, position: Int) {
        holder.configureWith(header)
    }

    override fun getItemCount(): Int = 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> CellTypes.HEADER.ordinal
            1 -> CellTypes.GENERAL.ordinal
            else -> CellTypes.EXPERIENCE.ordinal
        }
    }
}

