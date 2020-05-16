package com.test.ui.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/com/test/ui/cucumber/features"},
        format = {"pretty", "html:target/reports/cucumber/html",
                "json:target/cucumber.json", "usage:target/usage.jsonx",
                "junit:target/junit.xml", "html:target/cucumber-pretty"})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
