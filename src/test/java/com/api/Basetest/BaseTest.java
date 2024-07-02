package com.api.Basetest;

import com.api.Utilities.GlobalVariables;
import com.api.Utilities.Routes;
import com.api.actions.AssertActions;
import com.api.PayloadManagers.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public RequestSpecBuilder requestSpecBuilder;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;

    @BeforeMethod
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
