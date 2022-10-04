package com.msdt.car_rental.domain;

import java.util.Objects;

public class User {
    private Long userId;
    private String username;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private Boolean userBlocked;
    private UserRole userRole;

    public User() {
    }

    public User(String username, String userEmail, String userPassword, String userAddress, Boolean userBlocked, UserRole userRole) {
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userBlocked = userBlocked;
        this.userRole = userRole;
    }

    public User(Long userId, String username, String userEmail, String userPassword, String userAddress, Boolean userBlocked, UserRole userRole) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userBlocked = userBlocked;
        this.userRole = userRole;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Boolean getUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(Boolean userBlocked) {
        this.userBlocked = userBlocked;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userAddress, user.userAddress) && Objects.equals(userBlocked, user.userBlocked) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, userEmail, userPassword, userAddress, userBlocked, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userBlocked=" + userBlocked +
                ", userRole=" + userRole +
                '}';
    }
}
