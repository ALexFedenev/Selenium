package ru.fedenev.framework.steps;

import io.cucumber.java.ru.И;
import ru.fedenev.framework.managers.PageManager;

public class StartPageStep {
    private final PageManager pageManager = PageManager.getPageManager();


    @И("^Проверяем что окно открылось и жмем 'Каталог'$")
    public void clickCatalog() {
        pageManager.getStartPage().clickCatalog();
    }

    @И("^Выбираем вкладку \"(.+)\"$")
    public void moveElement(String nameElement) {
        pageManager.getStartPage().moveElement(nameElement);
    }


    @И("^Жмем подменю\"(.+)\"$")
    public void selectSubMenu(String nameSubMenu) {
        pageManager.getStartPage().selectSubMenu(nameSubMenu);
    }
}
