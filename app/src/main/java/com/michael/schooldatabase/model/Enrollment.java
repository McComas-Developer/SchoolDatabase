package com.michael.schooldatabase.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "EnrollmentTable",primaryKeys = {"ssn", "courseId"}, foreignKeys = {
        @ForeignKey(entity = Course.class,
        parentColumns = "courseId",
        childColumns = "courseId"
        ),
        @ForeignKey(entity = Student.class,
        parentColumns = "ssn",
        childColumns = "ssn")} , indices = { @Index("courseId"), @Index("ssn")})

public class Enrollment {
    @NonNull public String ssn;
    @NonNull public String courseId;
    public String dateRegistered;
    public String grade;

    public Enrollment(String ssn, String courseId, String dateRegistered, String grade ) {
        this.ssn = ssn;
        this.courseId = courseId;
        this.dateRegistered = dateRegistered;
        this.grade = grade;
    }
}