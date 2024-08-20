package com.example.retrofit.repository

import com.example.retrofit.model.Course
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CourseRepository {
    @GET("courses")
    fun getAllCourses(@Query("name") name : String?) : Call<List<Course>>

    @GET("courses/{course_id}")
    fun getCourseById(@Path("course_id") courseId : Long) : Call<Course>

    @POST("courses")
    fun createCourse(@Body course : Course) : Call<Any>

    @PUT("courses/{course_id}")
    fun updateCourse(@Path("course_id") courseId : Long, @Body course : Course) : Call<Any>

    @DELETE("courses/{course_id}")
    fun deleteCourseById(@Path("course_id") courseId : Long) : Call<Unit>

    @DELETE("courses")
    fun deleteAllCourses() : Call<Unit>
}