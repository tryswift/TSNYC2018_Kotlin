package com.jonbott.portfolio.RecyclerResume

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jonbott.portfolio.R
import com.jonbott.portfolio.RecyclerResume.Entities.ResumeHeader

typealias ItemClickLambda = (v: View, position: Int)->Unit

enum class CellTypes {
    HEADER,
    GENERAL,
    EXPERIENCE
}


class ResumeViewAdapter(val resumeHeader: ResumeHeader,
                        val summary: String,
                        val currentWork: List<JobInfo>,
                        val previousWork: List<JobInfo>,
                        var headerItemClick: ItemClickLambda)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ResumeHeaderViewHolder -> holder.configureWith(resumeHeader)
            is ResumeGeneralViewHolder -> holder.configureWith(summary)
            is ResumeExperienceViewHolder -> {
                val jobInfo = currentWork[0]
                holder.configureWith(jobInfo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        println("🍄: position: $viewType")

        val cellType = CellTypes.values()[viewType]

        when (cellType) {
            CellTypes.HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_resume_header, parent, false)
                val viewHolder = ResumeHeaderViewHolder(view)
                view.setOnClickListener { v -> headerItemClick(v, viewHolder.adapterPosition) }

                return viewHolder
            }

            CellTypes.GENERAL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_general_text, parent, false)

                return ResumeGeneralViewHolder(view)
            }

            CellTypes.EXPERIENCE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_resume_experience, parent, false)

                return ResumeExperienceViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int = 3

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> CellTypes.HEADER.ordinal
            1 -> CellTypes.GENERAL.ordinal
            1 -> CellTypes.EXPERIENCE.ordinal
            else -> CellTypes.EXPERIENCE.ordinal
        }
    }
}

