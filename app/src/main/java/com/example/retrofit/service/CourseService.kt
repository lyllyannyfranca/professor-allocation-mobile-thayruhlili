package com.example.retrofit.service

import com.example.retrofit.model.Course
import com.example.retrofit.repository.CourseRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseService (private val courseRepository: CourseRepository) {

    fun getAllCourses(name : String?, onCall: (coursesList: List<Course>?) -> Unit, onError: (messageError : String) -> Unit) {
        courseRepository.getAllCourses(name).enqueue(object : Callback<List<Course>> {
            override fun onResponse(p0: Call<List<Course>>, response: Response<List<Course>>) {
                val courses = response.body()
                onCall(courses)
            }

            override fun onFailure(p0: Call<List<Course>>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }

    fun getCourseById(courseId : Long, onCall: (course : Course?) -> Unit, onError: (messageError : String) -> Unit) {
        courseRepository.getCourseById(courseId).enqueue(object : Callback<Course> {
            override fun onResponse(p0: Call<Course>, response: Response<Course>) {
                val course = response.body()
                onCall(course)
            }

            override fun onFailure(p0: Call<Course>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }

    fun createCourse(course: Course, onCall : () -> Unit, onError : (messageError : String) -> Unit) {
        courseRepository.createCourse(course).enqueue(object : Callback<Any> {
            override fun onResponse(p0: Call<Any>, p1: Response<Any>) {
                onCall()
            }

            override fun onFailure(p0: Call<Any>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }

    fun updateCourse(courseId : Long, course : Course, onCall: () -> Unit, onError: (messageError : String) -> Unit) {
        courseRepository.updateCourse(courseId, course).enqueue(object : Callback<Any> {
            override fun onResponse(p0: Call<Any>, p1: Response<Any>) {
                onCall()
            }

            override fun onFailure(p0: Call<Any>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }

    fun deleteCourseById(courseId: Long, onCall: () -> Unit, onError: (messageError : String) -> Unit) {
        courseRepository.deleteCourseById(courseId).enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                onCall()
            }

            override fun onFailure(p0: Call<Unit>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }

    fun deleteAllCourses(onCall: () -> Unit, onError: (messageError : String) -> Unit) {
        courseRepository.deleteAllCourses().enqueue(object : Callback<Unit> {
            override fun onResponse(p0: Call<Unit>, p1: Response<Unit>) {
                onCall()
            }

            override fun onFailure(p0: Call<Unit>, response: Throwable) {
                val message = response.message

                if (message != null) onError(message)
            }
        })
    }
}