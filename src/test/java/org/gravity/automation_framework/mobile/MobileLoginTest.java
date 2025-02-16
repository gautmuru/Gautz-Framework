package org.gravity.automation_framework.mobile;



import org.gravity.automation_framework.base.*;
import org.gravity.automation_framework.utilities.JsonUtils;
import org.json.simple.JSONObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileLoginTest extends MobileBaseclass {
@Test
public void testMobileAppFlow() {
    // Read test data from JSON file
    JSONObject testData = JsonUtils.parseJsonFile("src/main/resources/mobileapptestdata.json");
    JSONObject mobileData = (JSONObject) testData.get("mobile");

    String platformName = (String) mobileData.get("platformName");
    String deviceName = (String) mobileData.get("deviceName");
    String appPackage = (String) mobileData.get("appPackage");
    String appActivity = (String) mobileData.get("appActivity");

    // Locate and interact with elements in the app
    MobileElement appMenu = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
    appMenu.click();

    MobileElement activityMenu = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Activity']"));
    activityMenu.click();

    MobileElement customTitleMenu = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Custom Title']"));
    customTitleMenu.click();

    // Validate the screen title
    MobileElement screenTitle = (MobileElement) driver.findElement(By.id("io.appium.android.apis:id/left_text_edit"));
    Assert.assertEquals(screenTitle.getText(), "Left is best", "Screen title mismatch!");
}

}