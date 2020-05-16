package com.test.ui.cucumber.steps;

import com.test.ui.cucumber.model.Customer;
import com.test.ui.cucumber.pageobjects.customers.CustomerPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Customers extends ParentSteps {

    @Autowired
    private CustomerPage customerPage;

    @Given("^Address to the Application$")
    public void openCustomersApplication() {
        customerPage.openCustomersPage(CUSTOMERS_PAGE);
    }

    @When("^I search (.*)$")
    public void i_search(String text) {
        customerPage.searchInput(text);
    }

    @When("^I Match case$")
    public void matchCase() {
        customerPage.matchCase();
    }

    @When("^Page is loaded$")
    public void pageIsLoaded() {
        customerPage.waitUntilCustomersPageIsLoaded();
    }

    @When("^I select (.*)$")
    public void i_select_id(String category) {
        customerPage.select(category);
    }

    @Then("^I can see the following Customers$")
    public void customersDisplayed(List<Customer> tableOfCustomers) {
        customerPage.customersTable(tableOfCustomers);
    }

    @When("^I can see none Customers$")
    public void noneCustomersInTable() {
        customerPage.noneCustomersInTable();
    }
}
