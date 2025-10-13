package com.mohamed.interview_study_generator_api.controller;

import com.mohamed.interview_study_generator_api.models.request.StudyGuideRequest;
import com.mohamed.interview_study_generator_api.models.response.StudyGuideResponse;
import com.mohamed.interview_study_generator_api.service.StudyGuideGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interview-guide")
@RequiredArgsConstructor
public class StudyGuideController {

    private final StudyGuideGeneratorService service;

    @PostMapping("/generate")
    public ResponseEntity<StudyGuideResponse> generateStudyGuide(@RequestBody StudyGuideRequest requestPayload) {
        try {
            return ResponseEntity.ok(service.generateStudyGuide(requestPayload));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
