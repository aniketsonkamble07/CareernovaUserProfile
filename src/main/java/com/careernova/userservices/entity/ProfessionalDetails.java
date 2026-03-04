package com.careernova.userservices.entity;

import com.careernova.userservices.enums.CandidateType;
import com.careernova.userservices.enums.JobType;
import jakarta.persistence.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "professional_details")
public class ProfessionalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID userId;

    // Candidate Type
    @Enumerated(EnumType.STRING)
    private CandidateType candidateType; // FRESHER / EXPERIENCED

    private String currentRole;
    private String currentCompany;

    private Integer totalExperienceYears;
    private Integer relevantExperienceYears;

    private String highestQualification;
    private String universityName;
    private Integer graduationYear;
    private Double cgpa;

    private Double minSalary;
    private Double maxSalary;
    private String currency;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private Boolean activelyLooking;
    private Boolean openToRemote;
    private Boolean openToRelocation;

    private String preferredIndustry;
    private String noticePeriod;

    private UUID resumeId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
