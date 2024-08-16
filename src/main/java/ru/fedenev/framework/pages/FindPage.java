package ru.fedenev.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindPage extends BasePage {

    @FindBy(xpath = "//div[@aria-hidden='false']//input[@name='min']")
    private WebElement fieldMinPrice;

    @FindBy(xpath = "//span/label[@class='Checkbox_text__cMHC9']")
    private List<WebElement> listCheckBox;

    @FindBy(xpath = "//span[text()='Производитель:']")
    private WebElement field;

    @FindBy(xpath = "//div[text()='Товаров на странице: ']//span")
    private WebElement pluOnPage;

    @FindBy(xpath = "//a/div[@title]")
    private WebElement onePlu;
    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement fieldFind;
    @FindBy(xpath = "//div[@class='page_title h1 ListingLayout_titleWrapper__cx52q']")
    private WebElement elementWait;//элемент пропадает при обновлении блока поиска
    @FindBy(xpath = "//span[@class='ListingPageTitle_count__lIz5h ListingLayout_count__mj4WV']")
    private WebElement QuantityPluOnPage;
    @FindBy(xpath = "//a/div[@title]")
    private WebElement nameFirstElement;

    private String namePlu;

    public FindPage sendMinPrice(String value) {
        fillInputField(fieldMinPrice, value);
        return this;
    }

    public FindPage selectCheckBox(String nameCheckBox) {
        for (WebElement menuItem : listCheckBox) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameCheckBox)) {
                waitUtilElementToBeClickable(menuItem).click();
                waitUtilElementToBeVisible(elementWait);
                return this;
            }
        }
        Assert.fail("Меню '" + nameCheckBox + "' не было найдено на стартовой странице!");
        return this;

    }

    public FindPage checkPluOnPage(String massege) {
        waitUtilElementToBeVisible(pluOnPage);
        assertEquals("Проверка ошибки не пройдена", massege, pluOnPage.getText());
        return this;
    }


    public FindPage selectOnePluOnPage() {
        waitUtilElementToBeVisible(elementWait);
        waitUtilElementToBeVisible(onePlu);
        namePlu = onePlu.getText();
        return this;
    }

    public FindPage findPlu() {
        fillInputField(fieldFind, namePlu);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li/span[text()='Поиск']")));
        return this;
    }

    public FindPage getPluOnPage(String message) {
        waitUtilElementToBeVisible(QuantityPluOnPage);
        assertEquals("Проверка ошибки не пройдена", message, QuantityPluOnPage.getText());
        return this;
    }

    public FindPage compare() {
        waitUtilElementToBeVisible(nameFirstElement);
        assertEquals("Проверка ошибки не пройдена", namePlu, nameFirstElement.getText());
        return this;
    }

}
