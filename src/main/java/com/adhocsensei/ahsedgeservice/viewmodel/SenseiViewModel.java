package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.Course;

import java.util.LinkedHashSet;
import java.util.Objects;

public class SenseiViewModel {

    private Long id;
    private String firstName;
    private String lastName;

    //    validation for no repeats
    private String email;
    private String password;

    private String bio;

    private LinkedHashSet<Course> senseiCreatedCourses = new LinkedHashSet<>();
    private LinkedHashSet<Course> userRegisteredCourses = new LinkedHashSet<>();

    public SenseiViewModel() {
    }

    public SenseiViewModel(Long id, String firstName, String lastName, String email, String password, String bio, LinkedHashSet<Course> senseiCreatedCourses, LinkedHashSet<Course> userRegisteredCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.senseiCreatedCourses = senseiCreatedCourses;
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

    public LinkedHashSet<Course> getSenseiCreatedCourses() {
        return senseiCreatedCourses;
    }

    public void setSenseiCreatedCourses(LinkedHashSet<Course> senseiCreatedCourses) {
        this.senseiCreatedCourses = senseiCreatedCourses;
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
        SenseiViewModel that = (SenseiViewModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getBio(), that.getBio()) && Objects.equals(getSenseiCreatedCourses(), that.getSenseiCreatedCourses()) && Objects.equals(getUserRegisteredCourses(), that.getUserRegisteredCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getPassword(), getBio(), getSenseiCreatedCourses(), getUserRegisteredCourses());
    }

    @Override
    public String toString() {
        return "SenseiViewModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", senseiCreatedCourses=" + senseiCreatedCourses +
                ", userRegisteredCourses=" + userRegisteredCourses +
                '}';
    }
}
