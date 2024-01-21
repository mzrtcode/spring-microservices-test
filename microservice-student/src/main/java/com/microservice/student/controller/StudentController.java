package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student, UriComponentsBuilder uriBuilder) {
        Student studentCreated = studentService.save(student);

        // Construir la URI del recurso creado
        var uri = uriBuilder.path("/api/students/{id}").buildAndExpand(studentCreated.getId()).toUri();
        // Devolver ResponseEntity con código de estado 201 Created y la URI del recurso creado
        return ResponseEntity.created(uri).body(studentCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> studentList = studentService.findAll();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/search-by-course/{courseId}")
    public ResponseEntity<List<Student>> findAllStudentByCourseId(@PathVariable("courseId") Long courseId){
        return ResponseEntity.ok(studentService.findByCourseId(courseId));
    }


}
