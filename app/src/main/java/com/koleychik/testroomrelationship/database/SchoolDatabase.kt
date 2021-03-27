package com.koleychik.testroomrelationship.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.koleychik.testroomrelationship.models.DirectorModel
import com.koleychik.testroomrelationship.models.SchoolModel
import com.koleychik.testroomrelationship.models.StudentModel

@Database(
    entities = [SchoolModel::class, DirectorModel::class, StudentModel::class],
    version = 1,
    exportSchema = true
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val dao: SchoolDao

    companion object {
        @Volatile
        private var instance: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            if (instance == null) synchronized(SchoolDatabase::class.java) {
                if (instance == null) instance = Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "SchoolDatabase"
                ).build()
            }
            return instance!!
        }

    }

}