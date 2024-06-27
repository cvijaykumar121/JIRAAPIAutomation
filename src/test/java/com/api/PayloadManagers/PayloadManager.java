package com.api.PayloadManagers;

import com.api.Payloads.ProjectCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadManager {
    // JAVA -> JSON
    private ObjectMapper objectMapper;

    public String createProjectCategoryPayload() {
        objectMapper = new ObjectMapper();
        ProjectCategory projectCategory = new ProjectCategory();
        projectCategory.setDescription("This project category is for Software Testing");
        projectCategory.setName("Software Testing");
        String payload = null;
        try {
            payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(projectCategory);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payload;
    }
}
