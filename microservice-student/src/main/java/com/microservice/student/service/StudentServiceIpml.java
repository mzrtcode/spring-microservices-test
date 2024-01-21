package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceIpml implements IStudentService{

    private final IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long idCourse) {
        return studentRepository.findAllStudentByCourseId(idCourse);
    }
}
