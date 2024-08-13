package com.example.retrofit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.listeners.MenuButtonsClickListener
import com.example.retrofit.model.MenuButton
import com.example.retrofit.viewHolders.MenuButtonsViewHolder

class MenuButtonsAdapter(
    private val menuButtons : List<MenuButton>,
    private val menuButtonClickListener : MenuButtonsClickListener
) : RecyclerView.Adapter<MenuButtonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuButtonsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_buttons, parent, false)
        return MenuButtonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuButtonsViewHolder, position: Int) {
        val item = menuButtons[position]
        holder.configuration(item)
        holder.itemView.setOnClickListener {
            menuButtonClickListener.loadActivity(position)
        }
    }

    override fun getItemCount(): Int {
        return menuButtons.size
    }
}