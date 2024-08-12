package ru.fedenev.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.fedenev.framework.managers.DriverManager;
import ru.fedenev.framework.managers.InitManager;
import ru.fedenev.framework.managers.PageManager;
import ru.fedenev.framework.managers.TestPropManager;

import static ru.fedenev.framework.utils.PropConstant.PropConst.BASE_URL;


public class BaseTests {
    protected PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterAll
    public static void afterAll() {
        //InitManager.quitFramework();
    }

}
