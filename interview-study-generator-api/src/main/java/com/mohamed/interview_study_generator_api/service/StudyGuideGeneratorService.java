package com.mohamed.interview_study_generator_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohamed.interview_study_generator_api.models.request.StudyGuideRequest;
import com.mohamed.interview_study_generator_api.models.response.StudyGuideResponse;
import com.mohamed.interview_study_generator_api.prompts.StudyGuidePrompts;
import io.micrometer.common.util.StringUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class StudyGuideGeneratorService {
    private final ChatClient client;
    private final ObjectMapper objectMapper;

    public StudyGuideGeneratorService(ChatClient.Builder builder, ObjectMapper objectMapper) {
        this.client = builder.build();
        this.objectMapper = objectMapper;
    }

    public StudyGuideResponse generateStudyGuide(StudyGuideRequest studyGuideRequest) {
        StringBuilder mainContent = new StringBuilder().append(studyGuideRequest.getDomain());
        if (StringUtils.isNotBlank(studyGuideRequest.getSpecification())) {
            mainContent.append(" and ").append("following specifications ").append(studyGuideRequest.getSpecification());
        }
        ChatResponse chatResponse = null;
        try {
            String actualPrompt = StudyGuidePrompts.BASE_GUIDE.getPrompt().replace("PLACE_HOLDER", mainContent.toString());
            chatResponse = client.prompt().user(actualPrompt).call().chatResponse();
            String responseContent = chatResponse.getResult().getOutput().getText().replace("```json", "").replace("```", "");
            return objectMapper.readValue(responseContent, StudyGuideResponse.class);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
