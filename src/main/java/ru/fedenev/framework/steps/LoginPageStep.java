package ru.fedenev.framework.steps;

import io.cucumber.java.bg.И;
import ru.fedenev.framework.managers.PageManager;

public class LoginPageStep {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Вводим логин \"(.+)\" и пароль \"(.+)\"$")
    public void sendLoginPassword(String login, String pasword) {
        pageManager.getLoginPage().sendLoginPassword(login, pasword);
    }
    @И("Жмем кнопку войти")
    public void clickButton(){
        pageManager.getLoginPage().clickButton();
    }
}
