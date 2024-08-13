package com.example.retrofit.config

import com.example.retrofit.repository.AllocationRepository
import com.example.retrofit.repository.CourseRepository
import com.example.retrofit.repository.DepartmentRepository
import com.example.retrofit.repository.ProfessorRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val courseRepository = retrofit.create(CourseRepository::class.java)
    val departmentRepository = retrofit.create(DepartmentRepository::class.java)
    val professorRepository = retrofit.create(ProfessorRepository::class.java)
    val allocationRepository = retrofit.create(AllocationRepository::class.java)
}