package com.example.retrofit.service

import com.example.retrofit.model.Department
import com.example.retrofit.repository.DepartmentRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DepartmentService(private val departmentRepository: DepartmentRepository) {

    fun getAllDepartments(name: String, onCall: (departmentsList: List<Department>?) -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.getAllDepartments(name).enqueue(object : Callback<List<Department>> {
            override fun onResponse(call: Call<List<Department>>, response: Response<List<Department>>) {
                val departments = response.body()
                onCall(departments)
            }

            override fun onFailure(call: Call<List<Department>>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun getDepartmentById(departmentId: Long, onCall: (department: Department?) -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.getDepartmentById(departmentId).enqueue(object : Callback<Department> {
            override fun onResponse(call: Call<Department>, response: Response<Department>) {
                val department = response.body()
                onCall(department)
            }

            override fun onFailure(call: Call<Department>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun createDepartment(department: Department, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.createDepartment(department).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                onCall()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun updateDepartment(departmentId: Long, department: Department, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.updateDepartment(departmentId, department).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                onCall()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun deleteDepartmentById(departmentId: Long, onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.deleteDepartmentById(departmentId).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                onCall()
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                val message = t.message
                if (message != null) onError(message)
            }
        })
    }

    fun deleteAllDepartments(onCall: () -> Unit, onError: (messageError: String) -> Unit) {
        departmentRepository.deleteAllDepartments().enqueue(object : Callback<Unit> {
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
