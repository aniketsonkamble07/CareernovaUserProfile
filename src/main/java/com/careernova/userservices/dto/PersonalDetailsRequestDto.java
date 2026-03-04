package com.careernova.userservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class PersonalDetailsRequestDto {

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    private String mobileNumber;

    private String country;
    private String state;
    private String city;

    private String linkedinUrl;
    private String githubUrl;
    private String portfolioUrl;

    @Size(max = 500)
    private String profileSummary;
}
