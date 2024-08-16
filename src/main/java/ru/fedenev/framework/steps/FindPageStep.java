package ru.fedenev.framework.steps;

import io.cucumber.java.bg.И;
import ru.fedenev.framework.managers.PageManager;

public class FindPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Вводим минимальную цену \"(.+)\"$")
    public void sendLoginPassword(String price) {
        pageManager.getFindPage().sendMinPrice(price);
    }

    @И("^ВЫбираем чек-бокс по товару\"(.+)\"$")
    public void selectCheckBox(String nameCheck) {
        pageManager.getFindPage().selectCheckBox(nameCheck);
    }

    @И("^Проверяем что количество товаров выдает \"(.+)\"$")
    public void checkPluOnPage(String namber) {
        pageManager.getFindPage().checkPluOnPage(namber);
    }

    @И("^Сохранить наименование первого товара в списке$")
    public void selectOnePluOnPage() {
        pageManager.getFindPage().selectOnePluOnPage();
    }

    @И("^В поисковую строку ввести запомненное значение, выполнить поиск$")
    public void findPlu() {
        pageManager.getFindPage().findPlu();
    }

    @И("^На странице \"(.+)\"$")
    public void getPluOnPage(String quantity) {
        pageManager.getFindPage().getPluOnPage(quantity);
    }

    @И("Проверить, что наименование товара соответствует сохраненному значению")
    public void compare() {
        pageManager.getFindPage().compare();
    }
}