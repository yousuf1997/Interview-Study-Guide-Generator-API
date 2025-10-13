package com.mohamed.interview_study_generator_api.models.response;

import com.mohamed.interview_study_generator_api.models.general.StudyPrepTimeline;
import com.mohamed.interview_study_generator_api.models.general.StudyTopic;
import lombok.Data;

import java.util.List;

@Data
public class StudyGuideResponse {
    private String title;
    private List<StudyTopic> studyTopics;
    private List<StudyPrepTimeline> prepTimelines;
}
