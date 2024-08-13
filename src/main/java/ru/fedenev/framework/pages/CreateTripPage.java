package ru.fedenev.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

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

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    private WebElement buttonSave;
    @FindBy(xpath = "//span[text()='Внештатные сотрудники']/../..//span[contains(text(),'Список командируемых сотрудников не может быть пустым')]")
    private WebElement elementError;

    @Step
    public CreateTripPage waitUtilElement() {
        waitUtilElementToBeVisible(title);
        return this;
    }

    @Step
    public CreateTripPage checkOpenTripPage() {
        waitUtilElementToBeVisible(title);
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Создать командировку", title.getText());
        return this;
    }

    @Step
    public CreateTripPage clickDivisionField() {
        waitUtilElementToBeClickable(divisionField).click();
        return this;
    }

    @Step
    public CreateTripPage clickOpenRow() {
        waitUtilElementToBeClickable(openRows).click();
        return this;
    }

    @Step
    public CreateTripPage clickOpenOrgAndSelectOrgCheckBox() {
        waitUtilElementToBeClickable(selectOrg).click();
        waitUtilElementToBeClickable(selectOrganization).click();
        assertEquals("Поле было заполнено некорректно", "(Опера)Призрачная Организация Охотников", selectOrg.getText());
        waitUtilElementToBeClickable(checkBox).click();
        return this;
    }

    @Step
    public CreateTripPage sendField(String nameField, String value) {
        switch (nameField) {
            case "Город выбытия":
                fillInputField(fieldCity1, value);
                break;
            case "Город прибытия":
                fillInputField(fieldCity2, value);
                break;
            case "Дата выезда":
                fillInputField(fieldDateIn, value);
                break;
            case "Дата въезда":
                fillInputField(fieldDateOut, value);
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице ");
        }
        return this;
    }

    @Step
    public CreateTripPage clickButtonSave() {
        waitUtilElementToBeClickable(buttonSave).click();
        return this;
    }

    @Step
    public CreateTripPage checkErrorMessageAtField() {
        waitUtilElementToBeVisible(elementError);
        assertEquals("Проверка ошибки не пройдена", "Список командируемых сотрудников не может быть пусты", elementError.getText());
        return this;
    }
}

