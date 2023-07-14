package com.aditya.courseManagement.payloads;

import lombok.Data;

@Data
public class CourseDTO {

    private long id;

    private String title;

    private String description;
}
