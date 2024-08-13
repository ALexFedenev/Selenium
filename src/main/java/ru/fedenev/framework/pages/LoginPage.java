package ru.fedenev.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement waitLoginForm;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button;

    public LoginPage waitUtilElement() {
        waitUtilElementToBeVisible(waitLoginForm);
        return this;
    }

    @Step
    public LoginPage sendLoginPassword(String valueLogin, String valuePass) {
        waitUtilElementToBeClickable(login).sendKeys(valueLogin);
        waitUtilElementToBeClickable(pass).sendKeys(valuePass);
        return this;
    }

    @Step
    public StartPage clickButton() {
        waitUtilElementToBeClickable(button).click();
        return pageManager.getStartPage();
    }

}
