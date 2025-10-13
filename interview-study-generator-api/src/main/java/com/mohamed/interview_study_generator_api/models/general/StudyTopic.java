package com.mohamed.interview_study_generator_api.models.general;

import lombok.Data;

import java.util.List;

@Data
public class StudyTopic {
    private String title;
    private String explanation;
    private String prosConsChallenges;
    private String approach;
    private List<StudyResource> resources;
    private List<StudyPrepTimeline> prepTimelines;
}
