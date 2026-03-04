package com.careernova.userservices.services;

import com.careernova.userservices.dto.PersonalDetailsResponseDto;
import com.careernova.userservices.entity.PersonalDetails;

public class PersonalDetailsMapper {

    public static PersonalDetailsResponseDto toDto(PersonalDetails entity) {
        return PersonalDetailsResponseDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .firstName(entity.getFirstName())
                .middleName(entity.getMiddleName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .email(entity.getEmail())
                .mobileNumber(entity.getMobileNumber())
                .country(entity.getCountry())
                .state(entity.getState())
                .city(entity.getCity())
                .linkedinUrl(entity.getLinkedinUrl())
                .githubUrl(entity.getGithubUrl())
                .portfolioUrl(entity.getPortfolioUrl())
                .profileSummary(entity.getProfileSummary())
                .profileCompleted(entity.getProfileCompleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
