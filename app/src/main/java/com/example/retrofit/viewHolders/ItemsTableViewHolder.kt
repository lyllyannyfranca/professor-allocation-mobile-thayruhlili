package com.example.retrofit.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.ItemsTable

class ItemsTableViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val tvId : TextView
    private val tvItem : TextView

    init {
        tvId = itemView.findViewById(R.id.tv_id)
        tvItem = itemView.findViewById(R.id.tv_item)
    }

    fun configuration(itemsTable : ItemsTable) {
        tvId.text = itemsTable.id.toString()
        tvItem.text = itemsTable.name
    }
}