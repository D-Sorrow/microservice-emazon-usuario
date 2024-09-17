package com.emazon.user.domain.model;

import com.emazon.user.adapters.driven.jpa.mysql.entity.RolEnum;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {

    private Long userId;

    private Long identityDocument;

    private String userName;

    private String userLastName;

    private String userPhoneNumber;

    private Date dateOfBirth;

    private String userEmail;

    private String userPassword;

    private RolEnum role;

    public User(Long userId, Long identityDocument, String userName, String userLastName, String userPhoneNumber, Date dateOfBirth, String userEmail, String userPassword, RolEnum role) {
        this.userId = userId;
        this.identityDocument = identityDocument;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userPhoneNumber = userPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(Long identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public RolEnum getRole() {
        return role;
    }

    public void setRole(RolEnum role) {
        this.role = role;
    }
}
