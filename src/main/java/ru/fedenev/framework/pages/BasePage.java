package ru.fedenev.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.fedenev.framework.managers.DriverManager;

import static org.junit.Assert.assertTrue;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    protected Actions action = new Actions(driverManager.getDriver());

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 50, 1000);

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUtilElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void fillInputField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        assertTrue("Поле было заполнено некорректно", checkFlag);
        element.sendKeys(Keys.ENTER);
    }

}
