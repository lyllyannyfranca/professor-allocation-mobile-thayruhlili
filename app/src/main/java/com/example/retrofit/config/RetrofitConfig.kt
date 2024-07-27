package com.example.retrofit.config

import com.example.retrofit.service.AllocationService
import com.example.retrofit.service.CourseService
import com.example.retrofit.service.DepartmentService
import com.example.retrofit.service.ProfessorService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://professor-allocation.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val courseService = retrofit.create(CourseService::class.java)
    val departmentService = retrofit.create(DepartmentService::class.java)
    val professorService = retrofit.create(ProfessorService::class.java)
    val allocationService = retrofit.create(AllocationService::class.java)
}