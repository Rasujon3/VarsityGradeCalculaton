package com.sujon.varsitygradecalculaton.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Semister {
    @PrimaryKey(autoGenerate = true)
    int id ;

    String semisterName;
    double semisterCredit;
    List<Course> semisterCourses;

    public Semister(String semisterName, double semisterCredit, List<Course> semisterCourses) {
        this.semisterName = semisterName;
        this.semisterCredit = semisterCredit;
        this.semisterCourses = semisterCourses;

    }

    public String getSemisterName() {
        return semisterName;
    }

    public void setSemisterName(String semisterName) {
        this.semisterName = semisterName;
    }

    public double getSemisterCredit() {
        return semisterCredit;
    }

    public void setSemisterCredit(double semisterCredit) {
        this.semisterCredit = semisterCredit;
    }

    public List<Course> getSemisterCourses() {
        return semisterCourses;
    }

    public void setSemisterCourses(List<Course> semisterCourses) {
        this.semisterCourses = semisterCourses;
    }
}
