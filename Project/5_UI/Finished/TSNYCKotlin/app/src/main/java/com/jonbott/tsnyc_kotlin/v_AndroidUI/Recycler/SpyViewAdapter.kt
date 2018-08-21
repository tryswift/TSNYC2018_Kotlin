package com.jonbott.tsnyc_kotlin.v_AndroidUI.Recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jonbott.Utils.Spy
import com.jonbott.tsnyc_kotlin.R

typealias ItemClickLambda = (v: View, position: Int)->Unit

class SpyViewAdapter(var onItemClick: ItemClickLambda) : RecyclerView.Adapter<SpyViewHolder>() {

    internal val spies = mutableListOf<Spy>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpyViewHolder {
        val spyView = LayoutInflater.from(parent.context).inflate(R.layout.spy_cell, parent, false)

        val spyViewHolder = SpyViewHolder(spyView)

        spyView.setOnClickListener { v -> onItemClick(v, spyViewHolder.adapterPosition) }

        return spyViewHolder
    }

    override fun onBindViewHolder(holder: SpyViewHolder, position: Int) {
        val spy = spies[position]
        holder.configureWith(spy)
    }

    override fun getItemCount(): Int = spies.size

    fun addSpy(spy: Spy) {
        spies.add(spy)
        notifyDataSetChanged()
    }
}