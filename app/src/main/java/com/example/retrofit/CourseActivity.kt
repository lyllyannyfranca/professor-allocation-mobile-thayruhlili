package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapters.ItemsTableAdapter
import com.example.retrofit.adapters.MenuButtonsAdapter
import com.example.retrofit.config.RetrofitConfig
import com.example.retrofit.fragments.MenuButtonsFragment
import com.example.retrofit.model.ItemsTable
import com.example.retrofit.model.MenuButton
import com.example.retrofit.repository.CourseRepository
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

        val itemsRecyclerView : RecyclerView = findViewById(R.id.rvCourseList)
        itemsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        var courseList = mutableListOf<ItemsTable>()

       val courseService : CourseService = CourseService(RetrofitConfig.courseRepository)

       courseService.getAllCourses(
           onCall = {courses ->
               if (courses != null) {
                   courses.forEach { course -> courseList.add(ItemsTable(course.id, course.name)) }
               }
           },
           onError = {
               Log.i(">>>", "Error!")
           }
       )

        val adapter = itemsRecyclerView(courseList)
        itemsRecyclerView.adapter = adapter

    }
}