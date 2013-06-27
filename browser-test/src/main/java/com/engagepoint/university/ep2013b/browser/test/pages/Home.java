package com.engagepoint.university.ep2013b.browser.test.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Home extends AbstractPage {

    public Home(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        get("http://localhost:8080/browser/home.xhtml"); //  --- > url in story
        manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void treeClick(String linktext){

        //findElement(By.linkText(linktext)).click();
        findElement(By.name(linktext)).click();
    }
}