package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.Course;

import java.util.LinkedHashSet;
import java.util.Objects;

public class StudentViewModel {

    private Long id;
    private String firstName;
    private String lastName;

    //    validation for no repeats
    private String email;
    private String password;

    private String bio;

    private LinkedHashSet<Course> userRegisteredCourses = new LinkedHashSet<>();

    public StudentViewModel() {
    }

    public StudentViewModel(Long id, String firstName, String lastName, String email, String password, String bio, LinkedHashSet<Course> userRegisteredCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.userRegisteredCourses = userRegisteredCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LinkedHashSet<Course> getUserRegisteredCourses() {
        return userRegisteredCourses;
    }

    public void setUserRegisteredCourses(LinkedHashSet<Course> userRegisteredCourses) {
        this.userRegisteredCourses = userRegisteredCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentViewModel that = (StudentViewModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getBio(), that.getBio()) && Objects.equals(getUserRegisteredCourses(), that.getUserRegisteredCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getBio(), getUserRegisteredCourses());
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", userRegisteredCourses=" + userRegisteredCourses +
                '}';
    }
}
