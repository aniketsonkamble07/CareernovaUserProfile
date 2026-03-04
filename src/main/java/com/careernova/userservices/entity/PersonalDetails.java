package com.careernova.userservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "personal_details")
@Getter
@Setter
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID userId;   // Comes from Auth Service

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;

    private String email;

    private String mobileNumber;

    private String country;

    private String state;

    private String city;

    private String linkedinUrl;

    private String githubUrl;

    private String portfolioUrl;

    private String profileSummary;   // Short bio

    private Boolean profileCompleted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}