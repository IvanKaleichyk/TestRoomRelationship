package com.koleychik.testroomrelationship

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.koleychik.testroomrelationship.database.SchoolDatabase
import com.koleychik.testroomrelationship.models.DirectorModel
import com.koleychik.testroomrelationship.models.SchoolModel
import com.koleychik.testroomrelationship.models.StudentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val tag = "MAIN_APP_TAG"

    private val dao by lazy { SchoolDatabase.getInstance(applicationContext).dao }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            addAllInformationToDb()

            for (i in listSchools) {
                Log.d(tag, "++++++++++++++++++++++++++++++++++++++++++++")
                dao.getSchoolAndDirectorWithSchoolName(i.schoolId).forEach { schoolAndDirector ->
                    Log.d(tag, "school id = ${schoolAndDirector.school.schoolId}")
                    Log.d(tag, "director name = ${schoolAndDirector.director.name}")
                }
                Log.d(tag, "-----------------------------------------------")
                dao.getSchoolAndStudentsWithSchoolName(i.schoolId).forEach { schoolAndStudents ->
                    Log.d(tag, "school id = ${schoolAndStudents.school.schoolId}")
                    schoolAndStudents.students.forEach { student ->
                        Log.d(tag, "student.name = ${student.name}")
                    }
                }
                Log.d(tag, "++++++++++++++++++++++++++++++++++++++++++++")
            }
        }
    }

    private suspend fun addAllInformationToDb() {
        for (i in listDirectors) dao.insertDirector(i)
        for (i in listSchools) dao.insertSchool(i)
        for (i in listStudents) dao.insertStudent(i)
    }

    private val listDirectors = listOf(
        DirectorModel("director1", 0),
        DirectorModel("director2", 1),
        DirectorModel("director3", 2),
    )

    private val listStudents = listOf(
        StudentModel("student1", 0),
        StudentModel("student2", 0),
        StudentModel("student3", 0),
        StudentModel("student4", 1),
        StudentModel("student5", 1),
        StudentModel("student6", 1),
        StudentModel("student7", 2),
        StudentModel("student8", 2),
        StudentModel("student9", 2),
    )

    private val listSchools = listOf(
        SchoolModel(0, "1"),
        SchoolModel(1, "2"),
        SchoolModel(2, "3"),
    )

}