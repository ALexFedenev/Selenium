package ru.fedenev.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.fedenev.framework.utils.PropConstant.PropConst.*;

public class DriverManager {

    protected WebDriver driver;

    private static DriverManager INSTANCE = null;

    private final TestPropManager props = TestPropManager.getTestPropManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        initDriverWindowsOsFamily();

    }

    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily(PATH_CHROME_DRIVER_WINDOWS);
    }

    private void initDriverAnyOsFamily(String chrome) {
        System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
        driver = new ChromeDriver();
    }

}
