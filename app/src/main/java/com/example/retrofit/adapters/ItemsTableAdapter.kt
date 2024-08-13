package com.example.retrofit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.ItemsTable
import com.example.retrofit.viewHolders.ItemsTableViewHolder

class ItemsTableAdapter(private val itemsTable : List<ItemsTable>) : RecyclerView.Adapter<ItemsTableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsTableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_table, parent, false)
        return ItemsTableViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsTableViewHolder, position: Int) {
        val item = itemsTable[position]
        holder.configuration(item)
    }

    override fun getItemCount(): Int {
        return itemsTable.size
    }
}