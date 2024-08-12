package ru.fedenev.framework.managers;

import ru.fedenev.framework.pages.CreateTripPage;
import ru.fedenev.framework.pages.LoginPage;
import ru.fedenev.framework.pages.StartPage;
import ru.fedenev.framework.pages.TripPage;

public class PageManager {

    private static PageManager pageManager;
    private LoginPage loginPage;
    private StartPage startPage;

    private TripPage tripPage;
    private CreateTripPage createTripPage;


    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;

    }


    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }
    public TripPage getTripPage() {
        if (tripPage == null) {
            tripPage = new TripPage();
        }
        return tripPage;
    }

    public CreateTripPage getCreateTripPage() {
        if (createTripPage == null) {
            createTripPage = new CreateTripPage();
        }
        return createTripPage;
    }

}