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
import com.example.retrofit.service.DepartmentService

class DepartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menuButtons, MenuButtonsFragment())
                .commit()
        }

        val searchDepartmentButton : SearchView = findViewById(R.id.sv_searchDepartment)

        val itemsTableRecyclerView : RecyclerView = findViewById(R.id.rvDepartmentList)
        itemsTableRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fetchDepartment(null, itemsTableRecyclerView);

        searchDepartmentButton.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(departmentSearched: String?): Boolean {
                if (departmentSearched != null) {
                    fetchDepartment(departmentSearched, itemsTableRecyclerView)
                }
                return true
            }
        })
    }

    private fun fetchDepartment(name : String?, item : RecyclerView) {
        var departmentList = mutableListOf<ItemsTable>()

        val departmentService : DepartmentService = DepartmentService(RetrofitConfig.departmentRepository)

        departmentService.getAllDepartments(
            name,
            onCall = {departments ->
                if (departments != null) {
                    departments.forEach { department ->
                        departmentList.add(ItemsTable(department.id, department.name))
                    }
                    departmentList.sortBy { it.id }
                    val adapter = ItemsTableAdapter(departmentList)
                    item.adapter = adapter
                } else {
                    Toast.makeText(this, "Nenhum departamento foi localizado!", Toast.LENGTH_SHORT)
                }

            },
            onError = {messageError ->
                Toast.makeText(this, "${messageError}", Toast.LENGTH_SHORT)
            }
        )
    }
}