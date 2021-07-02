package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.Course;
import com.adhocsensei.ahsedgeservice.dto.DAOUser;

import java.util.*;

public class UserViewModel {

    private Long id;
    private DAOUser DAOUser;

    private List<Course> senseiCreatedCourses = new ArrayList<>();
    private List<Optional<Course>> userRegisteredCourses = new ArrayList<>();

    public UserViewModel() {
    }

    public UserViewModel(Long id, DAOUser DAOUser, List<Course> senseiCreatedCourses, List<Optional<Course>> userRegisteredCourses) {
        this.id = id;
        this.DAOUser = DAOUser;
        this.senseiCreatedCourses = senseiCreatedCourses;
        this.userRegisteredCourses = userRegisteredCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DAOUser getUser() {
        return DAOUser;
    }

    public void setUser(DAOUser DAOUser) {
        this.DAOUser = DAOUser;
    }

    public List<Course> getSenseiCreatedCourses() {
        return senseiCreatedCourses;
    }

    public void setSenseiCreatedCourses(List<Course> senseiCreatedCourses) {
        this.senseiCreatedCourses = senseiCreatedCourses;
    }

    public List<Optional<Course>> getUserRegisteredCourses() {
        return userRegisteredCourses;
    }

    public void setUserRegisteredCourses(List<Optional<Course>> userRegisteredCourses) {
        this.userRegisteredCourses = userRegisteredCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserViewModel that = (UserViewModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getSenseiCreatedCourses(), that.getSenseiCreatedCourses()) && Objects.equals(getUserRegisteredCourses(), that.getUserRegisteredCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getSenseiCreatedCourses(), getUserRegisteredCourses());
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "id=" + id +
                ", DAOUser=" + DAOUser +
                ", senseiCreatedCourses=" + senseiCreatedCourses +
                ", userRegisteredCourses=" + userRegisteredCourses +
                '}';
    }
}
