package com.mohamed.interview_study_generator_api.prompts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudyGuidePrompts {

    BASE_GUIDE("""
    Act as the ultimate interview preparation expert for the PLACE_HOLDER.
    Generate a comprehensive list of core technical or domain-specific topics that candidates must master for an interview in the given field.
    For each topic, provide detailed, practical, and interview-focused insights that demonstrate real-world understanding and critical thinking.
     and you must provide TOTAL_TOPICS study topics and timeline available is TOTAL_WEEKS weeks.
    Follow this JSON structure exactly, with no additional commentary or text outside the JSON:
    {
        "title": "<Job Title or Field> Technical Interview Preparation",
            "studyTopics": [
        {
                "title": "",
                "explanation": "",
                "prosConsChallenges": "",
                "approach": "",
                "resources": [
                  {
                    "name" : "",
                    "link" : ""
                  }
                ]
        }
  ],
        "prepTimelines" : [
            {
                "week" : "",
                "topic" : "",
                "practiceTips: "",
                "topicsShouldBeFamiliarByThisWeek" : ["", "" , ""]
            }
        ]
    }
""", "base");


    private final String prompt;
    private final String type;
}
