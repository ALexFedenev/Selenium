package ru.fedenev.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.fedenev.framework.managers.DriverManager;
import ru.fedenev.framework.managers.PageManager;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    protected PageManager pageManager = PageManager.getPageManager();


    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 50, 1000);


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
