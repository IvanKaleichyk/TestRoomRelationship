package com.koleychik.testroomrelationship.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DirectorModel(val name: String, val schoolId: Int) {

    @PrimaryKey(autoGenerate = true)
    var directorId: Int = 0

}