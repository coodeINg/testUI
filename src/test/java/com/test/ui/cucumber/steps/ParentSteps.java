package com.test.ui.cucumber.steps;

import com.test.ui.cucumber.pageobjects.customers.CustomerPage;
import com.test.ui.cucumber.spring.CucumberContext;
import com.test.ui.cucumber.spring.PropertiesContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        CucumberContext.class,
        PropertiesContext.class,
        CustomerPage.class})
public class ParentSteps {
    protected static final String CUSTOMERS_PAGE = "index.html";

    @Autowired
    protected WebDriver webdriver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected boolean screenshotOnFailure;

    @Autowired
    protected String screenshotDestinationFolder;

}
