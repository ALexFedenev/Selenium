package ru.fedenev.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.fedenev.framework.managers.PageManager;
import ru.fedenev.framework.pages.CreateTripPage;

public class CreateTripPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("Проверяем что находимся на странице создания командировки")
    public void checkOpenTripPage() {
        pageManager.getCreateTripPage().checkOpenTripPage();
    }

    @И("Раскрываем поле 'Подразделение'")
    public void clickDivisionField() {
        pageManager.getCreateTripPage().clickDivisionField();
    }

    @И("И выбираем необходимое")
    public void clickOpenRow() {
        pageManager.getCreateTripPage().clickOpenRow();
    }

    @И("Далее вибираем оганизацию и ставим чек-бокс 'Заказ билетов'")
    public void clickOpenOrgAndSelectOrgCheckBox() {
        pageManager.getCreateTripPage().clickOpenOrgAndSelectOrgCheckBox();
    }

    @И("Заполняем поля")
    public void sendField(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getCreateTripPage().sendField((String) key, (String) value));
    }

    @И("Жмем кнопку 'Сохранить'")
    public void clickButtonSave() {
        pageManager.getCreateTripPage().clickButtonSave();
    }

    @И("^Проверяем что под полем появилось ожидаемое предупреждение \"(.+)\"$")
    public void checkErrorMessageAtField(String massege) {
        pageManager.getCreateTripPage().checkErrorMessageAtField(massege);
    }
}

