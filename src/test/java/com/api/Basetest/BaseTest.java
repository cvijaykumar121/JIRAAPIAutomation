package com.api.Basetest;

import com.api.Utilities.GlobalVariables;
import com.api.actions.AssertActions;
import com.api.Endpoints.Routes;
import com.api.PayloadManagers.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.core.appender.routing.Route;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public RequestSpecBuilder requestSpecBuilder;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
//    public RequestSpecification createProjectCategoryWithValidRequestBody;
    public RequestSpecBuilder createProjectCategoryWithValidRequestBodyBuilder;
    public JsonPath jsonPath;
//    public Response response;

    @BeforeClass
    public void setUpConfig() {
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(Routes.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((GlobalVariables.USERNAME + ":" + GlobalVariables.PASSWORD).getBytes()))
                .setContentType("application/json");
        requestSpecification = requestSpecBuilder.build().log().all();
    }
}
