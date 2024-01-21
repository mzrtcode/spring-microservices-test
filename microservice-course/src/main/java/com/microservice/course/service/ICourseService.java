package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    Course save(Course course);

    StudentsByCourseResponse findStudentsByIdCourse(Long idCourse);


}
