package com.example.retrofit

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapters.ItemsTableAdapter
import com.example.retrofit.config.RetrofitConfig
import com.example.retrofit.fragments.MenuButtonsFragment
import com.example.retrofit.model.ItemsTable
import com.example.retrofit.service.ProfessorService

class ProfessorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professor)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menuButtons, MenuButtonsFragment())
                .commit()
        }

        val searchProfessorButton : SearchView = findViewById(R.id.sv_searchProfessor)

        val itemsTableRecyclerView : RecyclerView = findViewById(R.id.rvProfessorList)
        itemsTableRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fetchProfessor(null,itemsTableRecyclerView)

        searchProfessorButton.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(professorSearched: String?): Boolean {
                if (professorSearched != null) {
                    fetchProfessor(professorSearched, itemsTableRecyclerView)
                }
                return true
            }
        })
    }

    private fun fetchProfessor(name : String?, item : RecyclerView) {
        var professorList = mutableListOf<ItemsTable>()

        val professorService : ProfessorService = ProfessorService(RetrofitConfig.professorRepository)

        professorService.getAllProfessors(
            name,
            onCall = {professors ->
                if (professors != null) {
                    professors.forEach { professor ->
                        professorList.add(ItemsTable(professor.id, professor.name))
                    }
                    professorList.sortBy { it.id }
                    val adapter = ItemsTableAdapter(professorList)
                    item.adapter = adapter
                } else {
                    Toast.makeText(this, "Nenhum professor foi localizado!", Toast.LENGTH_SHORT)
                }

            },
            onError = {messageError ->
                Toast.makeText(this, "${messageError}", Toast.LENGTH_SHORT)
            }
        )
    }
}