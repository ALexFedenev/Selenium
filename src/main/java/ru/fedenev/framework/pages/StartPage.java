package ru.fedenev.framework.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//button/span[text()='Каталог']")
    private WebElement buttonCatalog;

    @FindBy(xpath = "//li/a/div")
    private List<WebElement> listMenuCatalog;

    @FindBy(xpath = "//a/span[@itemprop='name']")
    private List<WebElement> listSabMenuCatalog;


    public StartPage clickCatalog() {
        waitUtilElementToBeClickable(buttonCatalog).click();
        return this;
    }


    public StartPage selectBaseMenu(String nameBaseMenu) {
        for (WebElement menuItem : listMenuCatalog) {
            if (menuItem.getText().trim().equalsIgnoreCase(nameBaseMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameBaseMenu + "' не было найдено на стартовой странице!");
        return this;

    }


    public TripPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuItem : listSabMenuCatalog) {
            if (menuItem.getText().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuItem).click();
                return pageManager.getTripPage();
            }
        }
        Assert.fail("Меню '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return pageManager.getTripPage();
    }


}
