package com.careernova.userservices.dto;
import com.careernova.userservices.enums.CandidateType;
import com.careernova.userservices.enums.JobType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfessionalDetailsRequestDto {

    private CandidateType candidateType;

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

    private JobType jobType;

    private Boolean activelyLooking;
    private Boolean openToRemote;
    private Boolean openToRelocation;

    private String preferredIndustry;
}