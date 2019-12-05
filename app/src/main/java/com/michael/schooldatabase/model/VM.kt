package com.michael.schooldatabase.model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michael.schooldatabase.db.SchoolDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM : ViewModel() {
    private var db: SchoolDatabase? = null
    private val searchResults = MutableLiveData<Resource<List<String>>>()

    fun buildDatabase(context: Context) {
        db = SchoolDatabase(context)
    }

    fun reset() {
        CoroutineScope(Dispatchers.IO ).launch {
            db?.schoolDao()?.deleteAllEnrollments()
            db?.schoolDao()?.deleteAllCourses()
            db?.schoolDao()?.deleteAllStudents()

            db?.schoolDao()?.insertCourse(
                Course("11111", "CSCI", 1301, "Introduction to Java I", 4),
                Course("11112", "CSCI", 1302, "Introduction to Java II", 3),
                Course("11113", "CSCI", 3720, "Database Systems", 3),
                Course("11114", "CSCI", 4750, "Rapid Java Application", 3),
                Course("11115", "MATH", 2750, "Calculus I", 5),
                Course("11116", "MATH", 3750, "Calculus II", 5),
                Course("11117", "EDUC", 1111, "Reading", 3),
                Course("11118", "ITEC", 1344, "Database Administration", 3)
            )

            db?.schoolDao()?.insertStudent(
                Student("444111110", "Jacob", "R", "Smith", "9129219434","1985-04-09", "Kingston Street", "31435", "BIOL"),
                Student("444111111", "John", "K", "Stevenson", "9129219434","null", "Main Street", "31411", "BIOL"),
                Student("444111112", "George", "K", "Smith", "9129213454","1974-10-10", "Abercorn St.", "31419", "CS"),
                Student("444111113", "Frank", "E", "Jones", "9125919434","1970-09-09", "Main Street", "31411", "BIOL"),
                Student("444111114", "Jean", "K", "Smith", "9129219434","1970-02-09", "Main Street", "31411", "CHEM"),
                Student("444111115", "Josh", "R", "Woo", "7075989434","1970-02-09", "Franklin St.", "31411", "CHEM"),
                Student("444111116", "Josh", "R", "Smith", "9129219434","1973-02-09", "Main Street", "31411", "BIOL"),
                Student("444111117", "Joy", "P", "Kennedy", "9129229434","1974-03-19", "Bay Street", "31412", "CS"),
                Student("444111118", "Toni", "R", "Peterson", "9129229434","1964-04-29", "Bay Street", "31412", "MATH"),
                Student("444111119", "Patrick", "R", "Stoneman", "9129229434","1969-04-29", "Washington St.", "31435", "MATH"),
                Student("444111120", "Rick", "R", "Carter", "9125919434","1986-04-09", "West Ford St.", "31411", "BIOL")
                )

            db?.schoolDao()?.insertEnrollment(
                Enrollment("444111110", "11111", "2004-03-19", "A"),
                Enrollment("444111110", "11112", "2004-03-19", "B"),
                Enrollment("444111110", "11113", "2004-03-19", "C"),
                Enrollment("444111111", "11111", "2004-03-19", "D"),
                Enrollment("444111111", "11112", "2004-03-19", "F"),
                Enrollment("444111111", "11113", "2004-03-19", "A"),
                Enrollment("444111112", "11114", "2004-03-19", "B"),
                Enrollment("444111112", "11115", "2004-03-19", "C"),
                Enrollment("444111112", "11116", "2004-03-19", "D"),
                Enrollment("444111113", "11111", "2004-03-19", "A"),
                Enrollment("444111113", "11113", "2004-03-19", "A"),
                Enrollment("444111114", "11115", "2004-03-19", "B"),
                Enrollment("444111115", "11115", "2004-03-19", "F"),
                Enrollment("444111115", "11116", "2004-03-19", "F"),
                Enrollment("444111116", "11111", "2004-03-19", "D"),
                Enrollment("444111117", "11111", "2004-03-19", "D"),
                Enrollment("444111118", "11111", "2004-03-19", "A"),
                Enrollment("444111118", "11112", "2004-03-19", "D"),
                Enrollment("444111118", "11113", "2004-03-19", "B")
                )
        }
    }

    fun searchSuppliers(query: String) {
        searchResults.value = Resource.Loading()
        CoroutineScope(Dispatchers.IO).launch {
            var result = Resource.Success(
                db!!.schoolDao().retrieveGrades(
                    query
                )
            )
            var newResult = arrayListOf<String>()
            result.data!!.forEach { newResult.add(it.firstName + " " + it.mi + " " + it.lastName + "\'s grade on course " + it.title + " is " + it.grade) }
            searchResults.postValue(Resource.Success(newResult))
        }
    }

    fun getSearch() = searchResults
}
