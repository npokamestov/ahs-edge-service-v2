package com.adhocsensei.ahsedgeservice.service;

import com.adhocsensei.ahsedgeservice.dao.AuthorityRepository;
import com.adhocsensei.ahsedgeservice.dao.UserRepository;
import com.adhocsensei.ahsedgeservice.dto.*;
import com.adhocsensei.ahsedgeservice.util.feign.CourseApiClient;
import com.adhocsensei.ahsedgeservice.util.feign.SenseiApiClient;
import com.adhocsensei.ahsedgeservice.util.feign.StudentApiClient;
import com.adhocsensei.ahsedgeservice.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class AdHocSenseiService {

    private AuthorityRepository authRepo;
    private UserRepository userRepo;
    private CourseApiClient courseClient;
    private SenseiApiClient senseiClient;
    private StudentApiClient studentClient;

    @Autowired
    public AdHocSenseiService(AuthorityRepository authRepo, UserRepository userRepo, CourseApiClient courseClient, SenseiApiClient senseiClient, StudentApiClient studentClient) {
        this.authRepo = authRepo;
        this.userRepo = userRepo;
        this.courseClient = courseClient;
        this.senseiClient = senseiClient;
        this.studentClient =studentClient;
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public DAOUser createUser(@RequestBody DAOUser user) {
        System.out.println("creating User in service layer");
        System.out.println(user);

        if (!userRepo.findAll().isEmpty()) {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                System.out.println("username already taken!");
                return null;
            }
        } else
                System.out.println(user);
            user.setEnabled(true);
                System.out.println(user);
            userRepo.save(user);
                System.out.println(user);

            DAOUser newUser = userRepo.findByUsername(user.getUsername());
                System.out.println(newUser);

            String authority = "";
            if (newUser.isInstructor()) {
                authority = "SENSEI";
            } else authority = "STUDENT";

            Authority newAuthority = new Authority();
            newAuthority.setUserId(newUser.getId());
            newAuthority.setUsername(newUser.getUsername());
            newAuthority.setAuthority(authority);
            authRepo.save(newAuthority);

            newUser.setAuthorityId(newAuthority.getId());
                System.out.println(newUser);
            userRepo.save(newUser);
                System.out.println(newUser);
            return newUser;
    }

//    public DAOUser getUserById(@PathVariable Long id) {
//        return userRepo.getById(id);
//    }

    public void updateUserById(@PathVariable Long id, @RequestBody DAOUser DAOUser){
        Optional<DAOUser> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            DAOUser.setId(id);
            DAOUser.setEnabled(true);
            DAOUser.setAuthorityId(authRepo.getById(optionalUser.get().getAuthorityId()).getId());
            userRepo.save(DAOUser);
        }
//        catch error and have appropriate response
    }

    public void deleteUserById(@PathVariable Long id) {
        DAOUser DAOUserToDelete = userRepo.getById(id);

        if (DAOUserToDelete.isInstructor()) {

            List<Sensei> senseisListOfCreatedCourses = senseiClient.getAllSenseiCoursesBySenseiId(id);

            senseisListOfCreatedCourses.forEach(sensei->studentClient.getAllStudentCoursesByCourseId(sensei.getCourseId())
                    .parallelStream().forEach(student->studentClient.deleteStudentCourseById(student.getId())));

            senseisListOfCreatedCourses.forEach(s->courseClient.deleteCourseById(s.getCourseId()));
            senseisListOfCreatedCourses.forEach(s->senseiClient.deleteSenseiCourseById(s.getId()));
        }
        List<Student> studentsListOfCoursesToDelete = studentClient.getAllStudentCoursesByStudentId(id);

        studentsListOfCoursesToDelete.forEach(s -> studentClient.deleteStudentCourseById(s.getId()));
        authRepo.deleteById(DAOUserToDelete.getAuthorityId());
        userRepo.deleteById(id);
    }

    public UserViewModel getUserViewModel(@PathVariable Long id) {
        if (userRepo.getById(id).isInstructor()) {
            return buildSenseiDash(id);
        } else return buildStudentDash(id);
    }

    public UserViewModel buildSenseiDash(@PathVariable Long id) {
        DAOUser thisDAOUser = userRepo.getById(id);
        List<Course> senseisCreatedCourses = getAllCoursesBySenseiId(id);
        List<Optional<Course>> registeredCourses = getAllRegisteredCoursesForUserById(id);

        UserViewModel vm = new UserViewModel();
        vm.setUser(thisDAOUser);
        vm.setSenseiCreatedCourses(senseisCreatedCourses);
        vm.setUserRegisteredCourses(registeredCourses);
        return vm;
    }

    public UserViewModel buildStudentDash(@PathVariable Long id) {
        DAOUser thisDAOUser = userRepo.getById(id);
//        List<Course> senseisCreatedCourses = getAllCoursesBySenseiId(id);
        List<Optional<Course>> registeredCourses = getAllRegisteredCoursesForUserById(id);

        UserViewModel vm = new UserViewModel();
        vm.setUser(thisDAOUser);
//        vm.setSenseiCreatedCourses(senseisCreatedCourses);
        vm.setUserRegisteredCourses(registeredCourses);
        return vm;
    }

//========================Course=====================================
    public Course createCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setSenseiId(userRepo.getById(id).getId());
        Course createdCourse = courseClient.createCourse(course);

        Sensei sensei = new Sensei();
        sensei.setUserId(userRepo.getById(id).getId());
        sensei.setCourseId(createdCourse.getId());
        senseiClient.createSenseiCourse(sensei);

        return createdCourse;
    }

    public List<Course> getAllCourses(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String location,
                                      @RequestParam(required = false) String date,
                                      @RequestParam(required = false) String shortDescription,
                                      @RequestParam(required = false) Long senseiId) {
        return courseClient.getAllCourses(title, category, location, date, shortDescription,senseiId);
    }

    public List<Course> getAllCoursesBySenseiId(@PathVariable Long id) {
        return courseClient.getCourseBySenseiId(id);
    }

    public List<Optional<Course>> getAllRegisteredCoursesForUserById(@PathVariable Long id) {
        List<Student> registrations = studentClient.getAllStudentCoursesByStudentId(id);
        System.out.println(registrations);

        List<Optional<Course>> registeredCourses = new ArrayList<>();
        System.out.println(registeredCourses);

        registrations.forEach(registration->registeredCourses.add(courseClient.getCourseById(registration.getCourseId())));
        System.out.println(registeredCourses);

        return registeredCourses;
    }

    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseClient.getCourseById(id);
    }

    public void updateCourseById(@PathVariable Long senseiId, @PathVariable Long courseId, @RequestBody Course course) {
        Optional<Course> optionalCourse = courseClient.getCourseById(courseId);
        if (optionalCourse.isPresent()) {
            if(senseiId.equals(courseClient.getCourseById(courseId).get().getSenseiId())) {
                course.setId(courseId);
                courseClient.updateCourseById(courseId, course);
            }
        } //        catch error and have appropriate response
//        catch error and have appropriate response
    }

    public void deleteCourseById(@PathVariable Long senseiId, @PathVariable Long courseId) {
        if(senseiId.equals(courseClient.getCourseById(courseId).get().getSenseiId())) {
            courseClient.deleteCourseById(courseId);
            List<Student> registeredClasses = studentClient.getAllStudentCoursesByCourseId(courseId);
            registeredClasses.forEach(s->studentClient.deleteStudentCourseById(s.getId()));
        } //        catch error and have appropriate response
    }

    public void registerForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {

        Student newStudent = new Student();

        if (courseClient.getCourseById(courseId).get().getSenseiId().equals(studentId)) {
            System.out.println("can't register for your own class, throw error");
        }
        else if (!studentClient.getAllStudentCourses(studentId,courseId).isEmpty()) {
            System.out.println("you're already registered!");
        }
        else {
            newStudent.setCourseId(courseId);
            newStudent.setUserId(studentId);
            studentClient.createStudentCourse(newStudent);
        }
    }

    public void unregisterForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        List<Student> registeredCourse = studentClient.getAllStudentCourses(studentId,courseId);
        if (registeredCourse.isEmpty()) {
            System.out.println("you aren't registered for this course!");
        } else
        studentClient.deleteStudentCourseById(registeredCourse.get(0).getId());
    }
}
