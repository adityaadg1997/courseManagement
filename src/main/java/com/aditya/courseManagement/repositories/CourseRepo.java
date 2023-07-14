package com.aditya.courseManagement.repositories;

import com.aditya.courseManagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
