package ru.fedenev.tests;

import org.junit.jupiter.api.Test;
import ru.fedenev.framework.managers.TestPropManager;

import static ru.fedenev.framework.utils.PropConstant.PropConst.*;


public class CreateTripTest extends BaseTests {

    @Test
    public void test() {
        //тестовые данные

        String division = "Отдел внутренней разработки";
        String hostOrganization = "(Опера)Призрачная Организация Охотников";
        String city1 = "Нижний Новгород";
        String city2 = "Тамбов";
        String dateIn = "10.08.2024";
        String dateOut = "20.08.2024";

        //авторизация
        app.getLoginPage().waitUtilElement()
                .sendLoginPassword(TestPropManager.getTestPropManager().getProperty(LOGIN),TestPropManager.getTestPropManager().getProperty(PASS))
                .clickButton().waitUtilElement()
                .selectBaseMenu("Расходы")
                .selectSubMenu("Командировки")
                .waitUtilElemen()
                .clickButton().waitUtilElement()
                .checkOpenTripPage()
                .clickDivisionField().clickOpenRow().clickOpenOrgAndSelect();


//        wait.until(visibilityOf(driver.findElement(By.xpath(String.format("//div[text()='%s']",
//                hostOrganization))))).click();//ждем список организаций и кликаем
//        driver.findElement(By.xpath("//label[text()='Заказ билетов']/../input")).click();//ставим чек-бокс
//        WebElement city = driver.findElement(By.xpath("//input[@data-name='field__departure-city']"));
//        fillInputField(city, city1);
//        fillInputField(driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")), city2);
//        fillInputField(driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_d')]")), dateIn);
//        fillInputField(driver.findElement(By.xpath("//input[@placeholder='Укажите дату' and contains(@id,'date_selector_crm_business_trip_r')]")), dateOut);
//
//        //проверяем поля подразделение и организация
        //      assertEquals(division, divisionActualText, "Поле было заполнено некорректно");
//        assertEquals(hostOrganization, driver.findElement(By.xpath("//span[@class='select2-chosen']")).getText(), "Поле было заполнено некорректно");
//        // сохранить и закрыть
//        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
//        loading();
//        WebElement element = driver.findElement(By.xpath("//span[text()='Внештатные сотрудники']/../..//span[contains(text(),'Список командируемых сотрудников не может быть пустым')]"));
//        String errorMessage = "Список командируемых сотрудников не может быть пустым";
//        checkErrorMessageAtField(element, errorMessage);
//    }
    }
}