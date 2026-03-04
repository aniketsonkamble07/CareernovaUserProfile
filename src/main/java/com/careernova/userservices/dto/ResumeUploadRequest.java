package com.careernova.userservices.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResumeUploadRequest {

    private UUID userId;
}