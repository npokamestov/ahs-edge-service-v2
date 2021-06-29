package com.adhocsensei.ahsedgeservice.util.feign;

import com.adhocsensei.ahsedgeservice.dto.Sensei;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sensei-api")
public interface SenseiApiClient {

    @GetMapping("/senseiCourse")
    public List<Sensei> getAllSenseiCourses();

    @GetMapping("/senseiCourse/{id}")
    public Sensei getSenseiCourseById(@PathVariable Long id);

    @PostMapping("/senseiCourse")
    public Sensei createSenseiCourse(@RequestBody Sensei sensei);

    @PutMapping("/senseiCourse/{id}")
    public void updateSenseiCourseById(@PathVariable Long id, @RequestBody Sensei sensei);

    @DeleteMapping("/senseiCourse/{id}")
    public void deleteSenseiCourseById(@PathVariable Long id);
}
