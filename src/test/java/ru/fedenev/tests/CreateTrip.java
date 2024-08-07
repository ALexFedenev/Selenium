package ru.fedenev.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class CreateTrip {
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
        String division = "Отдел внутренней разработки";
        String hostOrganization = "(Опера)Призрачная Организация Охотников";
        String city1 = "Нижний Новгород";
        String city2 = "Тамбов";
        String date1 = "10.08.2024";
        String date2 = "20.08.2024";

        //авторизация
        wait.until(visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Taraskina Valeriya");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
        //переход в командировки
        WebElement costsList = driver.findElement(By.xpath("//ul[contains(@class, 'nav-multilevel main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        wait.until(visibilityOf(costsList.findElement(By.xpath("./following::li/a/span[text()='Командировки']")))).click();
        loading();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
        //создание командировки
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        loading();
        wait.until(visibilityOf(driver.findElement(By.xpath("//h1[@class='user-name']"))));
        //заполняем командировку
        driver.findElement(By.xpath("//select[@name='crm_business_trip[businessUnit]']")).sendKeys(division);
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
        wait.until(visibilityOf(driver.findElement(By.xpath(String.format("//div[text()='%s']", hostOrganization))))).click();
        driver.findElement(By.xpath("//label[text()='Заказ билетов']/../input")).click();
        WebElement city = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
        city.clear();
        city.sendKeys(city1);
        driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")).sendKeys(city2);
        String citiActual = driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")).getAttribute("value");
        driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_d')]"))
                .sendKeys(date1);
        driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_r')]"))
                .sendKeys(date2);

        //проверяем поля
        Assertions.assertEquals(city2, citiActual, "Значения различаются");
        Assertions.assertEquals(city1, city.getAttribute("value"), "Значения различаются");
    }

    @AfterEach
    public void after() {
        //  driver.quit();
    }

    private void loading() {
        wait.until(invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));

    }

}
