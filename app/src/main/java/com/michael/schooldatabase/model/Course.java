package com.michael.schooldatabase.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CourseTable")
public class Course {
    @PrimaryKey @NonNull public String courseId;
    public String subjectId;
    public int courseNumber;
    public String title;
    public int numOfCredits;

    public Course(String courseId, String subjectId, int courseNumber, String title, int numOfCredits) {
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.courseNumber = courseNumber;
        this.title = title;
        this.numOfCredits = numOfCredits;
    }
}