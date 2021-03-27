package com.koleychik.testroomrelationship.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentModel(val name: String, val schoolId: Int) {
    @PrimaryKey(autoGenerate = true)
    var studentId: Int = 0
}
