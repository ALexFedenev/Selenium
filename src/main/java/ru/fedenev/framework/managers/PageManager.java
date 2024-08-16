package ru.fedenev.framework.managers;

import ru.fedenev.framework.pages.FindPage;
import ru.fedenev.framework.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;
    private FindPage findPage;
    private StartPage startPage;


    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public FindPage getFindPage() {
        if (findPage == null) {
            findPage = new FindPage();
        }
        return findPage;

    }


    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

}