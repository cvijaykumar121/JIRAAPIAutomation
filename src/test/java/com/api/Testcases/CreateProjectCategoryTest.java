package com.api.Testcases;

import com.api.Basetest.BaseTest;
import com.api.Endpoints.Routes;
import com.api.PayloadManagers.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateProjectCategoryTest extends BaseTest {
    public RequestSpecification createProjectCategoryWithValidRequestBody;

    @BeforeClass
    public void setUpBeforeCreateProjectCategoryTest() {
        payloadManager = new PayloadManager();
        createProjectCategoryWithValidRequestBodyBuilder = new RequestSpecBuilder();

        // Add base request specification to the custom builder
        createProjectCategoryWithValidRequestBodyBuilder.addRequestSpecification(requestSpecification)
                .setBasePath(Routes.CREATE_PROJECT_CATEGORY)
                .setBody(payloadManager.createProjectCategoryPayload());

        createProjectCategoryWithValidRequestBody = createProjectCategoryWithValidRequestBodyBuilder.build().log().all();
    }

    @Test(priority = 1)
    public void validateStatusCode() {
        // Ensure the request specification is not null
        if (createProjectCategoryWithValidRequestBody != null) {
            Response response = given(createProjectCategoryWithValidRequestBody).post();
            System.out.println(response.getStatusCode());
        } else {
            System.err.println("Request Specification is null.");
        }
    }
}
