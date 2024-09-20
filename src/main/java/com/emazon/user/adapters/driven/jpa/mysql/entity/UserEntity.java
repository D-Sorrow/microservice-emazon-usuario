package com.emazon.user.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;


@Entity
@AllArgsConstructor
@Data
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "user_document", nullable = false, unique = true)
    private Long identityDocument;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_last_name",nullable = false)
    private String userLastName;

    @Column(name = "user_phone_number",nullable = false)
    private String userPhoneNumber;

    @Column(name = "user_birth_date",nullable = false)
    private Date dateOfBirth;

    @Column(name = "user_email",nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_password",nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private RolEnum role;


}
