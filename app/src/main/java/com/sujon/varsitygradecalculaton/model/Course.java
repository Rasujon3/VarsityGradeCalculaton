package com.sujon.varsitygradecalculaton.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    int id ;
    
    String courseName;
    double courseGpa;
    double courseCredit;

    public Course(String courseName, double courseGpa, double courseCredit) {
        this.courseName = courseName;
        this.courseGpa = courseGpa;
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseGpa() {
        return courseGpa;
    }

    public void setCourseGpa(double courseGpa) {
        this.courseGpa = courseGpa;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }
}
