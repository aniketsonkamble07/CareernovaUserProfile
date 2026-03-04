package com.careernova.userservices.dto;



import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
public class PersonalDetailsResponseDto {

     public UUID id;
    public UUID userId;

    public String firstName;
    public String middleName;
    public String lastName;

    public LocalDate dateOfBirth;
    public String gender;

    public String email;
    public String mobileNumber;

    public String country;
    public String state;
    public String city;

    public String linkedinUrl;
    public String githubUrl;
    public String portfolioUrl;

    public String profileSummary;

    public Boolean profileCompleted;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
