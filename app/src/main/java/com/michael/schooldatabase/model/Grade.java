package com.michael.schooldatabase.model;

import androidx.room.Entity;

@Entity(tableName = "GradeTable")
public class Grade {
    public String firstName;
    public String mi;
    public String lastName;
    public String title;
    public String grade;

    public Grade(String firstName, String mi, String lastName, String title, String grade) {
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.title = title;
        this.grade = grade;
    }
}