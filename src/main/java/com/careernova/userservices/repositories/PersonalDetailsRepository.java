package com.careernova.userservices.repositories;

import com.careernova.userservices.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonalDetailsRepository  extends JpaRepository<PersonalDetails, UUID> {
    Optional<PersonalDetails> findByUserId(UUID userId);
    Optional<PersonalDetails> getByUserId(UUID userId);
}
