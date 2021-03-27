package com.koleychik.testroomrelationship.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.koleychik.testroomrelationship.models.SchoolModel
import com.koleychik.testroomrelationship.models.StudentModel

data class SchoolAndStudents(
    @Embedded val school: SchoolModel,
    @Relation(
        parentColumn = "schoolId",
        entityColumn = "schoolId"
    )
    val students: List<StudentModel>
)