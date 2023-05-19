package com.example.homework2.entity;

import com.example.homework2.enums.UserType;
import com.example.homework2.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "APP_USER")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    private Long id;

    @NotBlank
    @Column(name = "USERNAME", length = 100 , nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", length = 100,nullable = false)
    private String password;

    @NotNull
    @Column(name = "PHONE_NUMBER", length = 100, nullable = false)
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
