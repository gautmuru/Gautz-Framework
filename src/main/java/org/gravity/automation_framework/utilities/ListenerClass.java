package org.gravity.automation_framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerClass implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Override
    public void onStart(ITestContext testContext) {
        // Create a timestamp for the report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report-" + timeStamp + ".html";

        // Specify the location of the report
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);

        // Configure the report
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        // Create the ExtentReports object and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system information to the report
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Gautham");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log the test as passed in the report
        logger = extent.createTest(result.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log the test as failed in the report
        logger = extent.createTest(result.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        // Capture screenshot on failure
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
        File file = new File(screenshotPath);

        if (file.exists()) {
            logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log the test as skipped in the report
        logger = extent.createTest(result.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        // Flush the report (write all logs to the file)
        extent.flush();
    }
}