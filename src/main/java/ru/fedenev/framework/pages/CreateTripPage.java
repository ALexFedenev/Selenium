package ru.fedenev.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTripPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement title;

    @FindBy(xpath = "//option[text()='Отдел внутренней разработки']")
    private WebElement divisionField;
    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement openRows;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement selectOrg;
    @FindBy(xpath = "//div[text()='(Опера)Призрачная Организация Охотников']")
    private WebElement selectOrganization;
    @FindBy(xpath = "//label[text()='Заказ билетов']/../input")
    private WebElement checkBox;
    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    private WebElement fieldCity1;
    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    private WebElement fieldCity2;

    @FindBy(xpath = "//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_d')]")
    private WebElement fieldDateIn;
    @FindBy(xpath = "//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_r')]")
    private WebElement fieldDateOut;


    public CreateTripPage waitUtilElement() {
        waitUtilElementToBeVisible(title);
        return this;
    }

    public CreateTripPage checkOpenTripPage() {
        waitUtilElementToBeVisible(title);
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Создать командировку", title.getText());
        return this;
    }

    public CreateTripPage clickDivisionField() {
        waitUtilElementToBeClickable(divisionField).click();
        return this;
    }

    public CreateTripPage clickOpenRow() {
        waitUtilElementToBeClickable(openRows).click();
        return this;
    }

    public CreateTripPage clickOpenOrgAndSelect() {
        waitUtilElementToBeClickable(selectOrg).click();
        waitUtilElementToBeClickable(selectOrganization).click();
        return this;
    }

}
