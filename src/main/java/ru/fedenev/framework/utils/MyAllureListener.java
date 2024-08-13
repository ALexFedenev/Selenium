package ru.fedenev.framework.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.fedenev.framework.managers.DriverManager;

public class MyAllureListener extends AllureJunit4 {

    public void testFailure(final Failure failure) {
        byte[] image = ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        getLifecycle().addAttachment("Screen", "image/png", null, image);
        super.testFailure(failure);
    }
}
