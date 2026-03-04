package com.careernova.userservices.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    private String fileName;
    private String fileUrl;   // S3 / MinIO link
    private Long fileSize;

    private Integer atsScore;

    @Column(columnDefinition = "jsonb")
    private String extractedSkills;

    private LocalDateTime lastScannedAt;
    private LocalDateTime createdAt;
}
