package com.microservice.course.service;


import com.microservice.course.client.IStudentFeignClient;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.repository.ICourseRepository;
import dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements  ICourseService{

    private final ICourseRepository courseRepository;
    private final IStudentFeignClient client;


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultar curso
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        // Obtener los estudiantes
        List<StudentDto> studentDtoList = client.findAllStudentsByCourseId(idCourse);

        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }


}
