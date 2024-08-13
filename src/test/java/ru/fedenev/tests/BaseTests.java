package ru.fedenev.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.fedenev.framework.managers.DriverManager;
import ru.fedenev.framework.managers.InitManager;
import ru.fedenev.framework.managers.PageManager;
import ru.fedenev.framework.managers.TestPropManager;

import static ru.fedenev.framework.utils.PropConstant.PropConst.BASE_URL;


public class BaseTests {
    protected PageManager app = PageManager.getPageManager();

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }

}
