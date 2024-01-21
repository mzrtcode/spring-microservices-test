package com.microservice.course.client;

import dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/students")
public interface IStudentFeignClient {

    @GetMapping("/search-by-course/{courseId}")
    List<StudentDto> findAllStudentsByCourseId(@PathVariable Long courseId);
}
