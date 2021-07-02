package com.adhocsensei.ahsedgeservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String username;
    private String authority;

    public Authority() {
    }

    public Authority(Long id, Long userId, String username, String authority) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.authority = authority;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(getId(), authority1.getId()) && Objects.equals(getUserId(), authority1.getUserId()) && Objects.equals(getUsername(), authority1.getUsername()) && Objects.equals(getAuthority(), authority1.getAuthority());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getUsername(), getAuthority());
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
