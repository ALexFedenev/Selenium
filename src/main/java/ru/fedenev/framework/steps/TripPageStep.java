package ru.fedenev.framework.steps;

import io.cucumber.java.ru.И;
import ru.fedenev.framework.managers.PageManager;

public class TripPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем что открылось окно 'Командировки'$")
    public void waitUtilElement() {
        pageManager.getTripPage().waitUtilElement();
    }
    @И("^И жмем кнопку 'Создать командировку'$")
    public void clickButton(){
        pageManager.getTripPage().clickButton();
    }

}
