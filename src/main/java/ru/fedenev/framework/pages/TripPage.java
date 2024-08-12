package ru.fedenev.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class TripPage extends BasePage {
    @FindBy(xpath = "//li[text()='Командировки']")
    private WebElement titleTrip;

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement buttonCreateTrip;
    @FindBy(xpath = "//div[@class='loader-mask shown']/div/following::div/div")
    private WebElement loadingIcon;

    public TripPage waitUtilElemen() {
        waitUtilElementToBeVisible(titleTrip);
        return this;
    }

    public CreateTripPage clickButton() {
        waitUtilElementToBeClickable(buttonCreateTrip).click();
        return pageManager.getCreateTripPage();
    }

}
