package com.careernova.userservices.controller;

import com.careernova.userservices.dto.PersonalDetailsRequestDto;
import com.careernova.userservices.dto.PersonalDetailsResponseDto;
import com.careernova.userservices.services.PersonalDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/me/personal")
@RequiredArgsConstructor
public class PersonalDetailsController {

    private final PersonalDetailsService personalDetailsService;

    @GetMapping
    public ResponseEntity<PersonalDetailsResponseDto> getPersonalDetails() {
        UUID userId = getCurrentUserId(); // Extracted from JWT
        PersonalDetailsResponseDto dto = personalDetailsService.getByUserId(userId);

        if (dto == null) {
            return ResponseEntity.notFound().build(); // handle null (just in case)
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<PersonalDetailsResponseDto> updatePersonalDetails(
            @RequestBody @Valid PersonalDetailsRequestDto requestDto) {

        // Extract userId safely from JWT
        UUID userId = getCurrentUserId();

        // Save or update personal details
        PersonalDetailsResponseDto updatedDto = personalDetailsService.saveOrUpdate(userId, requestDto);

        // Return explicitly typed ResponseEntity
        return ResponseEntity.<PersonalDetailsResponseDto>ok(updatedDto);
    }

    private UUID getCurrentUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || auth.getPrincipal() == null) {
            throw new RuntimeException("User not authenticated");
        }

        Object principal = auth.getPrincipal();

        if (!(principal instanceof UUID)) {
            throw new RuntimeException("Invalid principal type");
        }

        return (UUID) principal;
    }
}
