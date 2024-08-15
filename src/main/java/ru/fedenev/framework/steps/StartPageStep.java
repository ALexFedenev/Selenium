package ru.fedenev.framework.steps;

import io.cucumber.java.ru.И;
import ru.fedenev.framework.managers.PageManager;
import ru.fedenev.framework.pages.StartPage;
import ru.fedenev.framework.pages.TripPage;

public class StartPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем что окно открылось$")
    public void waitUtilElement() {
        pageManager.getStartPage().waitUtilElement();
    }
    @И("^Выбираем вкладку \"(.+)\"$")
    public void selectBaseMenu(String nameBaseMenu){
        pageManager.getStartPage().selectBaseMenu(nameBaseMenu);
    }


    @И("^Жмем подменю\"(.+)\"$")
    public void selectSubMenu(String nameSubMenu) {
        pageManager.getStartPage().selectSubMenu(nameSubMenu);
    }
}
