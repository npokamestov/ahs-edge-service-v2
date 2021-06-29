package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "student-api")
public interface StudentApiClient {

    @GetMapping("/studentCourse")
    public List<Student> getAllStudentCourses();

    @GetMapping("/studentCourse/{id}")
    public Student getStudentCourseById(@PathVariable Long id);

    @PostMapping("/studentCourse")
    public Student createStudentCourse(@RequestBody Student student);

    @PutMapping("/studentCourse/{id}")
    public void updateStudentCourseById(@PathVariable Long id, @RequestBody Student student);

    @DeleteMapping("/studentCourse/{id}")
    public void deleteStudentCourseById(@PathVariable Long id);
}
