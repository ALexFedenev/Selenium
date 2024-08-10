package ru.fedenev.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class CreateTripTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("http://training.appline.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        //тестовые данные
        String login = "Taraskina Valeriya";
        String password = "testing";
        String division = "Отдел внутренней разработки";
        String hostOrganization = "(Опера)Призрачная Организация Охотников";
        String city1 = "Нижний Новгород";
        String city2 = "Тамбов";
        String dateIn = "10.08.2024";
        String dateOut = "20.08.2024";

        //авторизация
        wait.until(visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
        //переход в командировки
        WebElement costsList = driver.findElement(By.xpath("//ul[contains(@class, 'nav-multilevel main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        wait.until(visibilityOf(costsList.findElement(By.xpath("./following::li/a/span[text()='Командировки']")))).click();
        loading();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
        //создание командировки проверка открытия окна
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        loading();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='user-name']"))));
        //заполняем командировку
        driver.findElement(By.xpath("//select[@name='crm_business_trip[businessUnit]']"))
                .sendKeys(division);//в это поле подаем подразделение
        String divisionActualNumber = driver.findElement(By.xpath("//select[@name='crm_business_trip[businessUnit]']"))
                .getAttribute("value");
        String divisionActualText = driver.findElement(By.xpath(String.format("//option[@value='%s' and text()='%s']",
                divisionActualNumber, division))).getText();
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath(String.format("//div[text()='%s']",
                hostOrganization))))).click();//ждем список организаций и кликаем
        driver.findElement(By.xpath("//label[text()='Заказ билетов']/../input")).click();//ставим чек-бокс
        WebElement city = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
        fillInputField(city, city1);
        fillInputField(driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")), city2);
        fillInputField(driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_d')]")), dateIn);
        fillInputField(driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_r')]")), dateOut);

        //проверяем поля подразделение и организация
        assertEquals(division, divisionActualText, "Поле было заполнено некорректно");
        assertEquals(hostOrganization, driver.findElement(By.xpath("//span[@class='select2-chosen']")).getText(), "Поле было заполнено некорректно");
        // сохранить и закрыть
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        loading();
        WebElement element = driver.findElement(By.xpath("//span[text()='Внештатные сотрудники']/../..//span[contains(text(),'Список командируемых сотрудников не может быть пустым')]"));
        String errorMessage = "Список командируемых сотрудников не может быть пустым";
        checkErrorMessageAtField(element, errorMessage);
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    private void loading() {
        wait.until(invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));

    }

    private void fillInputField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        assertTrue(checkFlag, "Поле было заполнено некорректно");
        element.sendKeys(Keys.ESCAPE);
    }

    private void checkErrorMessageAtField(WebElement element, String errorMessage) {
        assertEquals(errorMessage, element.getText(), "Проверка ошибки у поля не была пройдена");
    }
}

