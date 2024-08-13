package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapters.MenuButtonsAdapter
import com.example.retrofit.config.RetrofitConfig
import com.example.retrofit.fragments.MenuButtonsFragment
import com.example.retrofit.listeners.MenuButtonsClickListener
import com.example.retrofit.model.MenuButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menuButtons, MenuButtonsFragment())
                .commit()
        }
    }
}