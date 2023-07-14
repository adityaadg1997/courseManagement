package com.aditya.courseManagement.services.impl;

import com.aditya.courseManagement.entities.Course;
import com.aditya.courseManagement.exception.ResourceNotFoundException;
import com.aditya.courseManagement.payloads.CourseDTO;
import com.aditya.courseManagement.repositories.CourseRepo;
import com.aditya.courseManagement.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = this.modelMapper.map(courseDTO, Course.class);
        Course savedCourse = this.courseRepo.save(course);

        return this.modelMapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public CourseDTO getCourse(long courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", "courseId", courseId));
        return this.modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<Course> allCourse = this.courseRepo.findAll();
        List<CourseDTO> courseDTOS = allCourse.stream().map(course -> this.modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
        return courseDTOS;
    }

    @Override
    public CourseDTO updateCourse(long courseId, CourseDTO courseDTO) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", "courseId", courseId));
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());

        this.courseRepo.save(course);

        return this.modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public void deleteCourse(long courseId) {
        Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("course", "courseId", courseId));
        this.courseRepo.deleteById(course.getId());
    }
}
