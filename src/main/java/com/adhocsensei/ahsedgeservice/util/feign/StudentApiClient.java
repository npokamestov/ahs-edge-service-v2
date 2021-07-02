package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.LongStream;

@FeignClient(name = "student-service")
public interface StudentApiClient {

    @GetMapping("/studentCourse")
    public List<Student> getAllStudentCourses(@RequestParam(required = false) Long userId,
                                              @RequestParam(required = false) Long courseId);

    @GetMapping("/studentCourse/{id}")
    public Student getStudentCourseById(@PathVariable Long id);

    @GetMapping("/studentCourse/studentList/{id}")
    public List<Student> getAllStudentCoursesByStudentId(@PathVariable Long id);

    @GetMapping("/studentCourse/senseisRegisteredCourses/{id}")
    public List<Student> getAllStudentCoursesByCourseId(@PathVariable Long id);

    @PostMapping("/studentCourse")
    public Student createStudentCourse(@RequestBody Student student);

    @PutMapping("/studentCourse/{id}")
    public void updateStudentCourseById(@PathVariable Long id, @RequestBody Student student);

    @DeleteMapping("/studentCourse/{id}")
    public void deleteStudentCourseById(@PathVariable Long id);
}
