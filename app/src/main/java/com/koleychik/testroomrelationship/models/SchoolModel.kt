package com.koleychik.testroomrelationship.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SchoolModel(
    @PrimaryKey(autoGenerate = false)
    val schoolId: Int,
    val name: String
)