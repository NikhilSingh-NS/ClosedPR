package com.example.myclosedprs.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myclosedprs.R
import com.example.myclosedprs.model.PRModel
import com.example.myclosedprs.util.ImageLoader
import com.example.myclosedprs.util.Utils
import com.squareup.picasso.Picasso
import java.lang.ref.WeakReference


class Adapter(private val prs: ArrayList<PRModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.user_avatar)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val title: TextView = itemView.findViewById(R.id.title)
        val createdAt: TextView = itemView.findViewById(R.id.created_at)
        val closeddAt: TextView = itemView.findViewById(R.id.closed_at)
        fun bind(PR: PRModel) {
            itemView.apply {
                userName.text = PR.user.userName
                title.text = context.getString(R.string.title, PR.id.toString(), PR.title)
                createdAt.text = context.getString(R.string.created_at, Utils.getFormattedDate(PR.createdDate))
                closeddAt.text = context.getString(R.string.closed_at, Utils.getFormattedDate(PR.closedDate))
                ImageLoader.loadImage(WeakReference(imageView), PR.user.userImage)
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