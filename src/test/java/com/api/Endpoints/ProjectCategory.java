package com.api.Endpoints;
import com.api.PayloadManagers.PayloadManager;
import com.api.Utilities.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ProjectCategory {
    public PayloadManager payloadManager;

    public ProjectCategory(PayloadManager payloadManager) {
        this.payloadManager = payloadManager;
    }

    public ProjectCategory() {

    }

    public Response createProjectCategoryWithValidData(RequestSpecification requestSpecification) {
        RequestSpecification createProjectCategoryWithValidData;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addRequestSpecification(requestSpecification)
                .setBody(payloadManager.createProjectCategoryPayload())
                .setBasePath(Routes.CREATE_PROJECT_CATEGORY);
        createProjectCategoryWithValidData = builder.build().log().all();
        return given(createProjectCategoryWithValidData).post();
    }

    public Response getAllProjectCategoriesWithValidData(RequestSpecification requestSpecification) {
        requestSpecification.basePath(Routes.CREATE_PROJECT_CATEGORY);
        return given(requestSpecification).get();
    }
}
