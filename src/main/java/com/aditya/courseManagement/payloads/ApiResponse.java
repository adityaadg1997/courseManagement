package com.aditya.courseManagement.payloads;

import com.aditya.courseManagement.exception.ResourceNotFoundException;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private boolean status;
}
