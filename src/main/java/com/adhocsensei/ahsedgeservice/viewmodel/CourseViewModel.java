package com.adhocsensei.ahsedgeservice.viewmodel;

import com.adhocsensei.ahsedgeservice.dto.DAOUser;

import java.util.LinkedHashSet;
import java.util.Objects;

public class CourseViewModel {

    private Long id;
    private String title;
    private String category;

    //    add format validation for date, time, duration
    private String date;
    private String time;
    private String location;
    private Integer duration;
    private Integer capacity;

    private String shortDescription;
    private String longDescription;

    private DAOUser DAOUser;

    private LinkedHashSet<DAOUser> registeredDAOUsers = new LinkedHashSet<>();

    public CourseViewModel() {
    }

    public CourseViewModel(Long id, String title, String category, String date, String time, String location, Integer duration, Integer capacity, String shortDescription, String longDescription, DAOUser DAOUser, LinkedHashSet<DAOUser> registeredDAOUsers) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.capacity = capacity;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.DAOUser = DAOUser;
        this.registeredDAOUsers = registeredDAOUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public DAOUser getUser() {
        return DAOUser;
    }

    public void setUser(DAOUser DAOUser) {
        this.DAOUser = DAOUser;
    }

    public LinkedHashSet<DAOUser> getRegisteredUsers() {
        return registeredDAOUsers;
    }

    public void setRegisteredUsers(LinkedHashSet<DAOUser> registeredDAOUsers) {
        this.registeredDAOUsers = registeredDAOUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseViewModel that = (CourseViewModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTime(), that.getTime()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getDuration(), that.getDuration()) && Objects.equals(getCapacity(), that.getCapacity()) && Objects.equals(getShortDescription(), that.getShortDescription()) && Objects.equals(getLongDescription(), that.getLongDescription()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getRegisteredUsers(), that.getRegisteredUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getCategory(), getDate(), getTime(), getLocation(), getDuration(), getCapacity(), getShortDescription(), getLongDescription(), getUser(), getRegisteredUsers());
    }

    @Override
    public String toString() {
        return "CourseViewModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", duration=" + duration +
                ", capacity=" + capacity +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", DAOUser=" + DAOUser +
                ", registeredDAOUsers=" + registeredDAOUsers +
                '}';
    }
}
