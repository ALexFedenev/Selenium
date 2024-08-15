package ru.fedenev.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPage extends BasePage {
    @FindBy(xpath = "//li[text()='Командировки']")
    private WebElement titleTrip;

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement buttonCreateTrip;
    @FindBy(xpath = "//div[@class='loader-mask shown']/div/following::div/div")
    private WebElement loadingIcon;


    public TripPage waitUtilElement() {
        waitUtilElementToBeVisible(titleTrip);
        return this;
    }


    public CreateTripPage clickButton() {
        waitUtilElementToBeClickable(buttonCreateTrip).click();
        return pageManager.getCreateTripPage();
    }

}
