package com.sujon.varsitygradecalculaton;

import androidx.room.*;
import com.sujon.varsitygradecalculaton.model.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void InsertCourse(Course course);
    @Delete
    void DeleteCourse(Course course);
    @Update
    void UpdateCourse(Course course);
    @Query("select * from Course where semisterId = :semisterId")
    List<Course>GetCoursesBySemisterId(int semisterId);

    @Insert
    void InsertCourseList(List<Course> courses);

    @Query("Delete from Course")
    void DeleteAllCourses();

}
