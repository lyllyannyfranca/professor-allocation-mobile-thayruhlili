package com.example.retrofit.service

import com.example.retrofit.model.Allocation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AllocationService {

    @GET("allocations")
    fun getAllAllocations() : Call<List<Allocation>>

    @GET("allocations/{allocation_id}")
    fun getAllocationById(@Path("allocation_id") allocationId : Long) : Call<Allocation>

    @GET("allocations/course/{course_id}")
    fun getAllocationsByCourse(@Path("course_id") courseId : Long) : Call<List<Allocation>>

    @GET("allocations/professor/{professor_id}")
    fun getAllocationsByProfessor(@Path("professor_id") professorId : Long) : Call<List<Allocation>>

    @POST("allocations")
    fun createAllocation(@Body allocation : Allocation) : Call<Any>

    @PUT("allocations/{allocation_id}")
    fun updateAllocation(@Path("allocation_id") allocationId: Long, @Body allocation : Allocation) : Call<Any>

    @DELETE("allocations/{allocation_id}")
    fun deleteAllocationById(@Path("allocation_id") allocationId: Long) : Call<Unit>

    @DELETE("allocations")
    fun deleteAllAllocations() : Call<Unit>
}