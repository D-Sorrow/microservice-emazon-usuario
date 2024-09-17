package com.emazon.user.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@Table(name = "user")
@NoArgsConstructor
public class UserEntity  {

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

    @Column(name = "user_email",nullable = false)
    private String userEmail;

    @Column(name = "user_password",nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private RolEnum role;


}
