package com.michael.schooldatabase.db

import androidx.room.*
import com.michael.schooldatabase.model.*

@Dao
interface SchoolDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEnrollment(vararg enrollment: Enrollment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent( vararg student: Student)

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertCourse(vararg course: Course)

    @Query("delete from EnrollmentTable")
    fun deleteAllEnrollments()

    @Query("delete from StudentTable")
    fun deleteAllStudents()

    @Query("delete from CourseTable")
    fun deleteAllCourses()

    @Query("select s.firstName, s.mi, s.lastName, c.title, e.grade from StudentTable s join EnrollmentTable e on s.ssn = e.ssn join CourseTable c on e.courseId = c.courseId where s.ssn = :ssn")
    fun retrieveGrades(ssn: String): List<Grade>

}