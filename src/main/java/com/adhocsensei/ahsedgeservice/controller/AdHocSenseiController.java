package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.DAOUser;
import com.adhocsensei.ahsedgeservice.service.AdHocSenseiService;
import com.adhocsensei.ahsedgeservice.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class AdHocSenseiController {

    @Autowired
    private AdHocSenseiService service;

//    ADD AT LEAST 10 MORE VALIDATIONS //////////////////////////////////////////////////

//    Authority Legend: ****** = SENSEI & STUDENT
//                      ###### = SENSEI

//    login (no restrictions)
    @GetMapping("/login")
    public String loggin(Principal principal) {
        return "Hello " + principal.getName();
    }

//    ******logout (student and sensei)
    @GetMapping("/loggedout")
    public String loggedOut() {
        return "You are logged out";
    }

//    get all courses (no restrictions) CHECKED
    @GetMapping("/course")
    public List<Course> getAllCourses(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String location,
                                      @RequestParam(required = false) String date,
                                      @RequestParam(required = false) String shortDescription,
                                      @RequestParam(required = false) Long senseiId) {
        return service.getAllCourses(title, category, location, date, shortDescription, senseiId);
    }

//    get one course (no restrictions) CHECKED
    @GetMapping("/course/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

//    *****get user dashboard - aka get a user and show their dashboard (student and sensei) CHECKED   ---- add validation that only the logged in user can see only their own dashboard
    @GetMapping("/userdash/{id}")
    public UserViewModel getUserDashBoardByUserId(@PathVariable Long id) {
        return service.getUserViewModel(id);
    }

//    ******update a DAOUser (student and sensei) CHECKED  ---- add validation that only the logged in user can update only themselves
    @PutMapping("/userdash/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody DAOUser DAOUser) {
        service.updateUserById(id, DAOUser);
    }

//    ******delete a user (student and sensei) CHECKED  ---- add validation that only the logged in user can delete only themselves
    @DeleteMapping("/userdash/{id}")
    public void deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
    }

//    *****get registered courses for user (student and sensei) CHECKED ---- add validation that only the logged in user can get courses for only themselves
    @GetMapping("/userdash/{id}/registeredcourses")
    public List<Optional<Course>> getAllRegisteredCoursesForUserByUserId(@PathVariable Long id) {
        return service.getAllRegisteredCoursesForUserById(id);
    }

//    ######get created courses for user (sensei) CHECKED ---- add validation that only the logged in sensei can get courses for only themselves
    @GetMapping("/senseidash/{id}/createdcourses")
    public List<Course> getAllSenseiCourses(@PathVariable Long id) {
        return service.getAllCoursesBySenseiId(id);
    }

//    ######create a course (sensei) CHECKED ---- add validation that only the logged in sensei can add courses for only themselves
    @PostMapping("/senseidash/{id}/createcourse")
    public Course createCourse(@PathVariable Long id, @RequestBody Course course) {
        return service.createCourse(id,course);
    }

//    ######update a course, but only the ones they created (sensei) CHECKED ---- add validation that only the logged in sensei can update courses for only themselves
    @PutMapping("/senseidash/{senseiId}/updatecourse/{courseId}")
    public void updateCourseById(@PathVariable Long senseiId, @PathVariable Long courseId, @RequestBody Course course) {
        service.updateCourseById(senseiId, courseId, course);
    }

//    ######delete a course, but only the ones they created (sensei) CHECKED ---- add validation that only the logged in sensei can remove courses for only themselves
    @DeleteMapping("/senseidash/{senseiId}/deletecourse/{courseId}")
    public void deleteCourseById(@PathVariable Long senseiId, @PathVariable Long courseId) {
        service.deleteCourseById(senseiId, courseId);
    }

//    ******register for a course (student and sensei) CHECKED ---- add validation that only the logged in user can register for a course and add to only their own list of registered courses
    @PostMapping("/student/{studentId}/course/{courseId}/register")
    public void registerForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        service.registerForCourse(studentId, courseId);
    }

//    ******unregister for a course (student and sensei) CHECKED ---- add validation that only the logged in user can unregister for a course and remove from only their own list of registered courses
    @DeleteMapping("/student/{studentId}/course/{courseId}/unregister")
    public void unregisterForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        service.unregisterForCourse(studentId, courseId);
    }

}
