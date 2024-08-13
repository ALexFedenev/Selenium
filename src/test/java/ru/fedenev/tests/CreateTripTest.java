package ru.fedenev.tests;

import org.junit.jupiter.api.Test;
import ru.fedenev.framework.managers.TestPropManager;

import static ru.fedenev.framework.utils.PropConstant.PropConst.*;


public class CreateTripTest extends BaseTests {

    @Test
    public void test() {
        //тестовые данные

        String city1 = "Нижний Новгород";
        String city2 = "Тамбов";
        String dateIn = "20.08.2024";
        String dateOut = "30.08.2024";

        //авторизация
        app.getLoginPage().waitUtilElement()
                .sendLoginPassword(TestPropManager.getTestPropManager().getProperty(LOGIN), TestPropManager.getTestPropManager().getProperty(PASS))
                .clickButton().waitUtilElement()
                .selectBaseMenu("Расходы")
                .selectSubMenu("Командировки")
                .waitUtilElement()
                .clickButton().waitUtilElement()
                .checkOpenTripPage()
                .clickDivisionField().clickOpenRow().clickOpenOrgAndSelectOrgCheckBox()
                .sendField("Город выбытия", city1).sendField("Город прибытия", city2)
                .sendField("Дата выезда", dateIn).sendField("Дата въезда", dateOut)
                .clickButtonSave().checkErrorMessageAtField();
    }
}