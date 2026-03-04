package com.careernova.userservices.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ResumeResponseDto {

    private UUID resumeId;
    private String fileName;
    private Long fileSize;
    private String fileUrl;
    private Integer atsScore;
    private LocalDateTime uploadedAt;
}