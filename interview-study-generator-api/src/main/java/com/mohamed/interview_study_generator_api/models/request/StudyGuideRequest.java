package com.mohamed.interview_study_generator_api.models.request;

import lombok.Data;

@Data
public class StudyGuideRequest {
    private String domain;
    private String specialization;
    private Integer numberOfTopics;
    private Integer numberOfWeeks;
}
