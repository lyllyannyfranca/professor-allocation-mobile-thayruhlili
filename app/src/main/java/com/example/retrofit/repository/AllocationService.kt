package com.example.retrofit.repository

import com.example.retrofit.model.Allocation
import com.example.retrofit.service.AllocationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllocationService(private val allocationService: AllocationService) {

    fun getAllAllocations(onCall: (allocationsList: List<Allocation>?) -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.getAllAllocations().enqueue(object : Callback<List<Allocation>> {
            override fun onResponse(call: Call<List<Allocation>>, response: Response<List<Allocation>>) {
                val allocations = response.body()
                onCall(allocations)
            }

            override fun onFailure(call: Call<List<Allocation>>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun getAllocationById(allocationId: Long, onCall: (allocation: Allocation?) -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.getAllocationById(allocationId).enqueue(object : Callback<Allocation> {
            override fun onResponse(call: Call<Allocation>, response: Response<Allocation>) {
                val allocation = response.body()
                onCall(allocation)
            }

            override fun onFailure(call: Call<Allocation>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun getAllocationsByCourse(courseId: Long, onCall: (allocationsList: List<Allocation>?) -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.getAllocationsByCourse(courseId).enqueue(object : Callback<List<Allocation>> {
            override fun onResponse(call: Call<List<Allocation>>, response: Response<List<Allocation>>) {
                val allocations = response.body()
                onCall(allocations)
            }

            override fun onFailure(call: Call<List<Allocation>>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun getAllocationsByProfessor(professorId: Long, onCall: (allocationsList: List<Allocation>?) -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.getAllocationsByProfessor(professorId).enqueue(object : Callback<List<Allocation>> {
            override fun onResponse(call: Call<List<Allocation>>, response: Response<List<Allocation>>) {
                val allocations = response.body()
                onCall(allocations)
            }

            override fun onFailure(call: Call<List<Allocation>>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun createAllocation(allocation: Allocation, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.createAllocation(allocation).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                onCall()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun updateAllocation(allocationId: Long, allocation: Allocation, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.updateAllocation(allocationId, allocation).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                onCall()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun deleteAllocationById(allocationId: Long, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.deleteAllocationById(allocationId).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                onCall()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun deleteAllAllocations(onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        allocationService.deleteAllAllocations().enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                onCall()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }
}
