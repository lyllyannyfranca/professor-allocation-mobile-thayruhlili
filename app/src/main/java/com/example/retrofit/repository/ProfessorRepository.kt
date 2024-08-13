package com.example.retrofit.repository

import com.example.retrofit.model.Professor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfessorRepository {

    @GET("professors")
    fun getAllProfessors(@Query("name") name : String) : Call<List<Professor>>

    @GET("professors/{professor_id}")
    fun getProfessorById(@Path("professor_id") professorId : Long) : Call<Professor>

    @GET("professors/department/{department_id}")
    fun getProfessorByDepartment(@Path("department_id") departmentId : Long) : Call<List<Professor>>

    @POST("professors")
    fun createProfessor(@Body professor : Professor) : Call<Any>

    @PUT("professors/{professor_id}")
    fun updateProfessor(@Path("professor_id") professorId : Long, @Body professor : Professor) : Call<Any>

    @DELETE("professors/{professor_id}")
    fun deleteProfessorById(@Path("professor_id") professorId: Long) : Call<Unit>

    @DELETE("professors")
    fun deleteAllProfessors() : Call<Unit>

}