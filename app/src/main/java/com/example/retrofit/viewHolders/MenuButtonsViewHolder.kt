package com.example.retrofit.viewHolders

import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.MenuButton

class MenuButtonsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val label : TextView
    private val icon : ImageView

    init {
        label = itemView.findViewById(R.id.tv_labelButton)
        icon = itemView.findViewById(R.id.iv_iconButton)
    }

    fun configuration(menuButton : MenuButton) {
        icon.setImageResource(menuButton.iconResource)
        label.text = menuButton.label
    }
}