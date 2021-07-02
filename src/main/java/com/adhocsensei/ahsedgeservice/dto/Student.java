package com.adhocsensei.ahsedgeservice.dto;

import java.util.Objects;

public class Student {

    private Long id;
    private Long userId;
    private Long courseId;

    public Student() {
    }

    public Student(Long id, Long userId, Long courseId) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getUserId(), student.getUserId()) && Objects.equals(getCourseId(), student.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getCourseId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                '}';
    }
}
