package com.example.myclosedprs.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myclosedprs.R
import com.example.myclosedprs.model.PRModel

class Adapter(private val prs: ArrayList<PRModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(PR: PRModel) {
            itemView.apply {

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(prs[position])
    }

    override fun getItemCount(): Int {
        return prs.size
    }


    fun addAllPRs(prs: List<PRModel>) {
        this.prs.apply {
            clear()
            addAll(prs)
        }

    }
}