package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "course-service")
public interface CourseApiClient {

    @GetMapping("/course")
    public List<Course> getAllCourses(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String location,
                                      @RequestParam(required = false) String date,
                                      @RequestParam(required = false) String shortDescription,
                                      @RequestParam(required = false) Long senseiId);

    @GetMapping("/course/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id);

    @GetMapping("/course/sensei/{id}")
    public List<Course> getCourseBySenseiId(@PathVariable Long id);

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course);

    @PutMapping("/course/{id}")
    public void updateCourseById(@PathVariable Long id, @RequestBody Course course);

    @DeleteMapping("/course/{id}")
    public void deleteCourseById(@PathVariable Long id);
}
