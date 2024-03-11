package com.nghiale.cruddemo.dao;

import com.nghiale.cruddemo.entity.Instructor;
import com.nghiale.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
