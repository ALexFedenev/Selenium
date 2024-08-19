package ru.fedenev.framework.managers;

import java.util.concurrent.TimeUnit;

import static ru.fedenev.framework.utils.PropConstant.PropConst.*;

public class InitManager {

    private static final TestPropManager props = TestPropManager.getTestPropManager();

    private static final DriverManager driverManager = DriverManager.getDriverManager();

    private static final PageManager pageManager = PageManager.getPageManager();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitDriver();
        pageManager.quitPageManager();
    }
}
