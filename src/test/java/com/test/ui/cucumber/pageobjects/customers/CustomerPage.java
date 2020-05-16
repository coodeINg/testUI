package com.test.ui.cucumber.pageobjects.customers;

import com.test.ui.cucumber.model.Customer;
import com.test.ui.cucumber.pageobjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.testng.Assert;

import java.util.List;

@Repository
public class CustomerPage extends PageObject {

    @Autowired
    protected WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"search-input\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//table")
    private WebElement table;

    @FindBy(xpath = "//*[@id=\"search-column\"]")
    private WebElement selectElem;

    @FindBy(xpath = "//*[@id=\"match-case\"]")
    private WebElement matchCaseElem;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void searchInput(String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    public void select(String select) {
        selectElem.click();
        Select fruits = new Select(selectElem);
        fruits.selectByVisibleText(select);
    }

    public void matchCase() {
        matchCaseElem.click();
    }

    private List<WebElement> getCustomersFromTableRows() {
        return table.findElements(By.xpath("//tbody/tr"));
    }

    public void openCustomersPage(String page) {
        webdriver.get(page);
    }

    public void waitUntilCustomersPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Customers']")));
    }


    public void customersTable(List<Customer> tableOfCustomers) {
        List<WebElement> results = this.getCustomersFromTableRows();
        Assert.assertTrue(results.size() == tableOfCustomers.size());
        checkCustomersTable(tableOfCustomers, results);
    }

    public void noneCustomersInTable() {
        List<WebElement> results = this.getCustomersFromTableRows();
        Assert.assertTrue(results.size() == 0);
    }

    private void checkCustomersTable(List<Customer> customers, List<WebElement> results) {
        for (int i = 0; i < customers.size(); i++) {
            String customerRow = customers.get(i).getId()
                    + " " + customers.get(i).getName()
                    + " " + customers.get(i).getEmail()
                    + " " + customers.get(i).getCity();
            String resultRow = results.get(i).getText();
            Assert.assertEquals(customerRow, resultRow);
        }
    }

}
