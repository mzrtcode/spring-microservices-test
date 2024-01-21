package com.microservice.course.controller;


import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @PostMapping("/students")
    public ResponseEntity<Course> saveStudent(@RequestBody Course course, UriComponentsBuilder uriBuilder) {
        Course courseCreated = courseService.save(course);

        // Construir la URI del recurso creado
        var uri = uriBuilder.path("/api/students/{id}").buildAndExpand(courseCreated.getId()).toUri();

        // Devolver ResponseEntity con código de estado 201 Created y la URI del recurso creado
        return ResponseEntity.created(uri).body(courseCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        List<Course> courseList = courseService.findAll();
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("search-students/{idCourse}")
    public ResponseEntity<StudentsByCourseResponse> findStudentsByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
    }


}
