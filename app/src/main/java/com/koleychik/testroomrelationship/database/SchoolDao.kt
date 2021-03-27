package com.koleychik.testroomrelationship.database

import androidx.room.*
import com.koleychik.testroomrelationship.models.DirectorModel
import com.koleychik.testroomrelationship.models.SchoolModel
import com.koleychik.testroomrelationship.models.StudentModel
import com.koleychik.testroomrelationship.relationships.SchoolAndDirector
import com.koleychik.testroomrelationship.relationships.SchoolAndStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(model: SchoolModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(model: DirectorModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(model: StudentModel)

    @Transaction
    @Query("SELECT * FROM SchoolModel WHERE schoolId = :schoolId")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolId: Int): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM SchoolModel WHERE schoolId = :schoolId")
    suspend fun getSchoolAndStudentsWithSchoolName(schoolId: Int): List<SchoolAndStudents>

}