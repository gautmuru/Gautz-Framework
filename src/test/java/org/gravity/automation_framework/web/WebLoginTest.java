package org.gravity.automation_framework.web;

import org.gravity.automation_framework.base.*;
import org.gravity.automation_framework.constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.gravity.automation_framework.pages.LoginPage;
import org.gravity.automation_framework.utilities.*;
import org.json.simple.JSONObject;

public class WebLoginTest extends BaseClass {
    @Test
    public void testLogin() {
        driver.get(Constants.WEB_URL);
        LoginPage loginPage = new LoginPage(driver);
        JSONObject testData = JsonUtils.parseJsonFile("src/main/resources/testdata.json");
        String username = (String) testData.get("username");
        String password = (String) testData.get("password");
        loginPage.login(username, password);
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
    }
}