package com.adhocsensei.ahsedgeservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    //    validation for no repeats
    private String username;
    @JsonIgnore
    private String password;

    private String bio;
    private boolean instructor;

    private boolean enabled;
    private Long authorityId;

    public DAOUser() {
    }

    public DAOUser(Long id, String firstName, String lastName, String username, String password, String bio, boolean instructor, boolean enabled, Long authorityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.instructor = instructor;
        this.enabled = enabled;
        this.authorityId = authorityId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DAOUser DAOUser = (DAOUser) o;
        return isInstructor() == DAOUser.isInstructor() && isEnabled() == DAOUser.isEnabled() && Objects.equals(getId(), DAOUser.getId()) && Objects.equals(getFirstName(), DAOUser.getFirstName()) && Objects.equals(getLastName(), DAOUser.getLastName()) && Objects.equals(getUsername(), DAOUser.getUsername()) && Objects.equals(getPassword(), DAOUser.getPassword()) && Objects.equals(getBio(), DAOUser.getBio()) && Objects.equals(getAuthorityId(), DAOUser.getAuthorityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUsername(), getPassword(), getBio(), isInstructor(), isEnabled(), getAuthorityId());
    }

    @Override
    public String toString() {
        return "DAOUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", instructor=" + instructor +
                ", enabled=" + enabled +
                ", authorityId=" + authorityId +
                '}';
    }
}
