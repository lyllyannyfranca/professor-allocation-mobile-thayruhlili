package com.example.retrofit.model

import kotlinx.datetime.DayOfWeek;
import kotlinx.datetime.LocalTime

data class Allocation(
    val id : Long,
    val day : DayOfWeek,
    val start : LocalTime,
    val end : LocalTime,
    val professor: Professor,
    val course : Course
)
