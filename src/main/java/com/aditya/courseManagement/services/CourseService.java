package com.aditya.courseManagement.services;

import com.aditya.courseManagement.payloads.CourseDTO;

import java.util.List;

public interface CourseService {

    //create
    CourseDTO createCourse(CourseDTO courseDTO);

    //read
    CourseDTO getCourse(long courseId);

    //read all
    List<CourseDTO> getAllCourse();

    //update
   CourseDTO updateCourse(long courseId, CourseDTO courseDTO);

    //delete
    void deleteCourse(long courseId);
}
