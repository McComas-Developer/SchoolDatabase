package com.michael.schooldatabase.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "StudentTable")
public class Student {
    @PrimaryKey @NonNull
    public String ssn;
    public String firstName;
    public String mi;
    public String lastName;
    public String phone;
    public String birthDate;
    public String street;
    public String zipCode;
    public String deptId;

    public Student(String ssn, String firstName, String mi, String lastName, String phone, String birthDate, String street, String zipCode, String deptId) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDate = birthDate;
        this.street = street;
        this.zipCode = zipCode;
        this.deptId = deptId;
    }
}
