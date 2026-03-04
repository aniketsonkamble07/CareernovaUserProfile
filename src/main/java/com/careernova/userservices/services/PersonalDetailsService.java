package com.careernova.userservices.services;

import com.careernova.userservices.dto.PersonalDetailsRequestDto;
import com.careernova.userservices.dto.PersonalDetailsResponseDto;
import com.careernova.userservices.entity.PersonalDetails;
import com.careernova.userservices.exceptions.UserNotFoundException;
import com.careernova.userservices.repositories.PersonalDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonalDetailsService {

    private final PersonalDetailsRepository personalDetailsRepository;

    public PersonalDetailsResponseDto getByUserId(UUID userId) {
        PersonalDetails entity = personalDetailsRepository
                .findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("User details not found!!"));

        // Map entity to DTO manually
        return PersonalDetailsMapper.toDto(entity);
    }
    public PersonalDetailsResponseDto saveOrUpdate(UUID userId, PersonalDetailsRequestDto requestDto) {

        // Try to find existing entity
        PersonalDetails entity = personalDetailsRepository.findByUserId(userId)
                .orElseGet(() -> {
                    // Create new entity if not found
                    PersonalDetails newEntity = new PersonalDetails();
                    newEntity.setUserId(userId);
                    newEntity.setCreatedAt(LocalDateTime.now());
                    return newEntity;
                });

        // Update fields
        if(requestDto.getFirstName() != null) entity.setFirstName(requestDto.getFirstName());
        if(requestDto.getMiddleName() != null) entity.setMiddleName(requestDto.getMiddleName());
        if(requestDto.getLastName() != null) entity.setLastName(requestDto.getLastName());
        if(requestDto.getDateOfBirth() != null) entity.setDateOfBirth(requestDto.getDateOfBirth());
        if(requestDto.getGender() != null) entity.setGender(requestDto.getGender());
        if(requestDto.getEmail() != null) entity.setEmail(requestDto.getEmail());
        if(requestDto.getMobileNumber() != null) entity.setMobileNumber(requestDto.getMobileNumber());
        if(requestDto.getCountry() != null) entity.setCountry(requestDto.getCountry());
        if(requestDto.getState() != null) entity.setState(requestDto.getState());
        if(requestDto.getCity() != null) entity.setCity(requestDto.getCity());
        if(requestDto.getLinkedinUrl() != null) entity.setLinkedinUrl(requestDto.getLinkedinUrl());
        if(requestDto.getGithubUrl() != null) entity.setGithubUrl(requestDto.getGithubUrl());
        if(requestDto.getPortfolioUrl() != null) entity.setPortfolioUrl(requestDto.getPortfolioUrl());
        if(requestDto.getProfileSummary() != null) entity.setProfileSummary(requestDto.getProfileSummary());

        // Profile completed check
        entity.setProfileCompleted(entity.getFirstName() != null && entity.getLastName() != null
                && entity.getEmail() != null && entity.getMobileNumber() != null);

        entity.setUpdatedAt(LocalDateTime.now());

        // Save new or updated entity
        personalDetailsRepository.save(entity);

        return PersonalDetailsMapper.toDto(entity);
    }
}