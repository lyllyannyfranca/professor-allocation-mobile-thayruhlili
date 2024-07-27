package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.config.RetrofitConfig
import com.example.retrofit.model.Course
import com.example.retrofit.repository.CourseRepository


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val course = Course(50, "Curso de Java")

        val courseRepository = CourseRepository(RetrofitConfig.courseService)

        courseRepository.createCourse(
            course = course,
            onCall = {
                Log.i(">>>", "Success!")
            },
            onError = {
                Log.i(">>>", "Error!")
            }
        )

    }
}