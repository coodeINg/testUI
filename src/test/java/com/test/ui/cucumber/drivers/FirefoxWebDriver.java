package com.test.ui.cucumber.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver {

    public WebDriver webdriver;

    public FirefoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        FirefoxOptions capabilities = new FirefoxOptions();
        this.webdriver = new FirefoxDriver(capabilities);
    }
}
