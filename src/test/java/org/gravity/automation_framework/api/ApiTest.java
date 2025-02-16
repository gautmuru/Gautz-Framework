package org.gravity.automation_framework.api;

import org.gravity.automation_framework.base.*;
import org.gravity.automation_framework.constants.Constants;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.gravity.automation_framework.utilities.*;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseTest {
    @Test
    public void testCreateUser() {
        // Read test data from JSON file (optional)
        JSONObject testData = JsonUtils.parseJsonFile("src/main/resources/apitestdata.json");

        // Define the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        // Send POST request
        Response response = given()
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .when()
                .post(Constants.API_URL + Constants.API_URL);

        // Validate the response status code
        Assert.assertEquals(response.getStatusCode(), 201, "User creation failed!");

        // Validate the response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("morpheus"), "User name not found in response!");
    }
}