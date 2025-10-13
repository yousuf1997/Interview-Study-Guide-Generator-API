package com.mohamed.interview_study_generator_api.models.general;

import lombok.Data;

import java.util.List;

@Data
public class StudyPrepTimeline {
      private String week;
      private String topic;
      private String practiceTips;
      private List<String> topicsShouldBeFamiliarByThisWeek;
}
