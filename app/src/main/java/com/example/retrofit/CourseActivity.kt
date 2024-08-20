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
import com.example.retrofit.service.CourseService

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menuButtons, MenuButtonsFragment())
                .commit()
        }

        val searchCourseButton : SearchView = findViewById(R.id.sv_searchCourse)

        val itemsTableRecyclerView : RecyclerView = findViewById(R.id.rvCourseList)
        itemsTableRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fetchCourse(null,itemsTableRecyclerView)

        searchCourseButton.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(courseSearched: String?): Boolean {
                if (courseSearched != null) {
                    fetchCourse(courseSearched, itemsTableRecyclerView)
                }
                return true
            }
        })
    }

    private fun fetchCourse(name : String?, item : RecyclerView) {
        var courseList = mutableListOf<ItemsTable>()

        val courseService : CourseService = CourseService(RetrofitConfig.courseRepository)

        courseService.getAllCourses(
            name,
            onCall = {courses ->
                if (courses != null) {
                    courses.forEach { course ->
                        courseList.add(ItemsTable(course.id, course.name))
                    }
                    courseList.sortBy { it.id }
                    val adapter = ItemsTableAdapter(courseList)
                    item.adapter = adapter
                } else {
                    Toast.makeText(this, "Nenhum curso foi localizado!", Toast.LENGTH_SHORT)
                }

            },
            onError = {messageError ->
                Toast.makeText(this, "${messageError}", Toast.LENGTH_SHORT)
            }
        )
    }
}