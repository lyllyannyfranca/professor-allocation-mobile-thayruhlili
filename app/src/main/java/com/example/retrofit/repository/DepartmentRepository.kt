package com.example.retrofit.repository

import com.example.retrofit.model.Department
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface DepartmentRepository {

    @GET("departments")
    fun getAllDepartments(@Query("name") name : String) : Call<List<Department>>

    @GET("departments/{department_id}")
    fun getDepartmentById(@Path("department_id") departmentId : Long) : Call<Department>

    @POST("departments")
    fun createDepartment(@Body department : Department) : Call<Any>

    @PUT("departments/{department_id}")
    fun updateDepartment(@Path("department_id") departmentId: Long, @Body department : Department) : Call<Any>

    @DELETE("departments/{department_id}")
    fun deleteDepartmentById(@Path("department_id") departmentId: Long) : Call<Unit>

    @DELETE("departments")
    fun deleteAllDepartments() : Call<Unit>
}