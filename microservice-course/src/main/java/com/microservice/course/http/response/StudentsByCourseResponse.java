package com.microservice.course.http.response;

import dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsByCourseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDto> studentDtoList;

}
