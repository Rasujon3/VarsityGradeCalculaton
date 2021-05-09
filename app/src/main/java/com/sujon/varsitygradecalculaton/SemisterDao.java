package com.sujon.varsitygradecalculaton;

import androidx.room.*;
import com.sujon.varsitygradecalculaton.model.Course;
import com.sujon.varsitygradecalculaton.model.Semister;

import java.util.List;

@Dao
public interface SemisterDao {
    @Insert
    void InsertSemister(Course course);

    @Delete
    void DeleteSemister(Course course);

    @Update
    void UpdateCourse(Course course);

    @Query("select * from Semister Order by id ASC")
    List<Semister> GetAllSemisters();

}
