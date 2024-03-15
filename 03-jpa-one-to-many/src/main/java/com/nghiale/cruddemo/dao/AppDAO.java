package com.nghiale.cruddemo.dao;

import com.nghiale.cruddemo.entity.Course;
import com.nghiale.cruddemo.entity.Instructor;
import com.nghiale.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorById(int theId);
    void deleteInstructorDetailById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
}
