package com.example.retrofit.service

import com.example.retrofit.model.Professor
import com.example.retrofit.repository.ProfessorRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfessorService(private val professorRepository1: ProfessorRepository) {

    fun getAllProfessors(name : String?, onCall : (professorsList : List<Professor>?) -> Unit, onError : (messageError : String) -> Unit) {
        professorRepository1.getAllProfessors(name).enqueue(object : Callback<List<Professor>> {
            override fun onResponse(p0: Call<List<Professor>>, response: Response<List<Professor>>) {
                val professors = response.body()
                onCall(professors)
            }

            override fun onFailure(p0: Call<List<Professor>>, response: Throwable) {
                val message = response.message
                if(message != null) onError(message)
            }
        })
    }

    fun getProfessorById(professorId : Long, onCall : (professor : Professor?) -> Unit, onError: (messageError: String) -> Unit) {
        professorRepository1.getProfessorById(professorId).enqueue(object : Callback<Professor> {
            override fun onResponse(p0: Call<Professor>, response: Response<Professor>) {
                val professor = response.body()
                onCall(professor)
            }

            override fun onFailure(p0: Call<Professor>, response: Throwable) {
                val message = response.message
                if (message != null) onError(message)
            }
        })
    }

    fun geProfessorByDepartment(departmentId : Long, onCall : (professorsList : List<Professor>?) -> Unit, onError: (message : String) -> Unit) {
        professorRepository1.getProfessorByDepartment(departmentId).enqueue(object : Callback<List<Professor>> {
            override fun onResponse(p0: Call<List<Professor>>, response: Response<List<Professor>>) {
                val professors = response.body()
                onCall(professors)
            }

            override fun onFailure(p0: Call<List<Professor>>, response: Throwable) {
                val message = response.message
                if (message != null) onError(message)
            }
        })
    }

    fun createProfessor(professor : Professor, onCall : () -> Unit, onError : (message : String) -> Unit) {
        professorRepository1.createProfessor(professor).enqueue(object : Callback<Any> {
            override fun onResponse(p0: Call<Any>, response: Response<Any>) {
                onCall()
            }

            override fun onFailure(p0: Call<Any>, response: Throwable) {
                val message = response.message
                if (message != null) onError(message)
            }
        })
    }
}