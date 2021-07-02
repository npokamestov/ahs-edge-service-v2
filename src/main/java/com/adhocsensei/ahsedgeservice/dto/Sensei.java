package com.adhocsensei.ahsedgeservice.dto;

import java.util.Objects;

public class Sensei {

    private Long id;
    private Long userId;
    private Long courseId;

    public Sensei() {
    }

    public Sensei(Long id, Long userId, Long courseId) {
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
        Sensei sensei = (Sensei) o;
        return Objects.equals(getId(), sensei.getId()) && Objects.equals(getUserId(), sensei.getUserId()) && Objects.equals(getCourseId(), sensei.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getCourseId());
    }

    @Override
    public String toString() {
        return "Sensei{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                '}';
    }
}
