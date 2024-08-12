package ru.fedenev.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class StartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement waitOpenPage;

    @FindBy(xpath = "//li/a/span[@class='title']")
    private List<WebElement> listBaseMenu;


    public StartPage waitUtilElement() {
        waitUtilElementToBeVisible(waitOpenPage);
        return this;
    }

    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : listBaseMenu) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;

    }

    public TripPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listBaseMenu) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getTripPage();
            }
        }
        Assert.fail("Меню '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getTripPage();
    }


}
