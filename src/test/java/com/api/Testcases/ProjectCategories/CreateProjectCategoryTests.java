package com.api.Testcases.ProjectCategories;

import com.api.Basetest.BaseTest;
import com.api.Endpoints.ProjectCategory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateProjectCategoryTests extends BaseTest {

    @Test(priority = 1)
    public void createProjectCategoryWithValidData() {
        ProjectCategory projectCategory = new ProjectCategory(payloadManager);
        Response response = projectCategory.createProjectCategoryWithValidData(requestSpecification);
        System.out.println("Response Code: " + response.getStatusCode());
        response.then()
                .statusCode(201) // 1. Status Code Validation
                .contentType("application/json") // 2. Content Type Validation
                .time(lessThan(5000L)) // 3. Response Time Validation
                .body("description", equalTo("This project category is for Software Testing")) // 4. Description Field Validation
                .body("name", equalTo("Software Testing")) // 5. Name Field Validation
                .body("description", not(anyOf(nullValue()))) // 8. Non-Empty Description Field
                .body("name", not(anyOf(nullValue())));
    }
}
