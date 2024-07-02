package com.api.Testcases.ProjectCategories;

import com.api.Basetest.BaseTest;
import com.api.Endpoints.ProjectCategory;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetAllProjectCategoriesTests extends BaseTest {

    @Test(priority = 1)
    public void getAllProjectCategoriesWithValidData() {
        ProjectCategory projectCategory = new ProjectCategory();
        Response response = projectCategory.getAllProjectCategoriesWithValidData(requestSpecification);
        System.out.println("Response Code: " + response.getStatusCode());
        response.then()
                .log().all()
                .statusCode(200)
                .body("", hasSize(greaterThan(0)));
    }
}
