package com.koleychik.testroomrelationship.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.koleychik.testroomrelationship.models.DirectorModel
import com.koleychik.testroomrelationship.models.SchoolModel

data class SchoolAndDirector(
    @Embedded val school: SchoolModel,
    @Relation(
        parentColumn = "schoolId",
        entityColumn = "schoolId"
    ) val director: DirectorModel
)