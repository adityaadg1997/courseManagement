package com.aditya.courseManagement.controller;

import com.aditya.courseManagement.payloads.ApiResponse;
import com.aditya.courseManagement.payloads.CourseDTO;
import com.aditya.courseManagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //create
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        CourseDTO createdCourse = this.courseService.createCourse(courseDTO);

        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    //read
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long courseId){
        CourseDTO course = this.courseService.getCourse(courseId);

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    //read all
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getALlCourse(){
        List<CourseDTO> allCourse = this.courseService.getAllCourse();

        return new ResponseEntity<>(allCourse, HttpStatus.OK);
    }

    //update
    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO){
        CourseDTO updatedCourse = this.courseService.updateCourse(courseId, courseDTO);

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    //delete
    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/{courseId}")
    public ResponseEntity<ApiResponse> createCourse(@PathVariable Long courseId){
        this.courseService.deleteCourse(courseId);

        return new ResponseEntity<>(new ApiResponse("course with courseId "+ courseId + " is successfully deleted", true), HttpStatus.OK);
    }
}
