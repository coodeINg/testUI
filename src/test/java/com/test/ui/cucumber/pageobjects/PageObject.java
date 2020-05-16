package com.test.ui.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObject {

    protected WebDriver webdriver;

    public PageObject(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.webdriver = driver;
    }
}
