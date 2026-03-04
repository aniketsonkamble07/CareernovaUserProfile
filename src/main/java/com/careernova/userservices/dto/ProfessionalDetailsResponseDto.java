package com.careernova.userservices.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ProfessionalDetailsResponseDto {

    private UUID id;
    private UUID userId;

    private String candidateType;   // FRESHER / EXPERIENCED

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

    private String jobType;

    private Boolean activelyLooking;
    private Boolean openToRemote;
    private Boolean openToRelocation;

    private String preferredIndustry;
    private String noticePeriod;

    private UUID resumeId;   // Reference to Resume Service

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
