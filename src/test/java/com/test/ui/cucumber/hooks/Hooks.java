package com.test.ui.cucumber.hooks;

import com.test.ui.cucumber.steps.ParentSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends ParentSteps {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            if (screenshotOnFailure) {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmss");
                String timestamp = sdf.format(now);

                File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
                File destFile = new File(screenshotDestinationFolder
                        + timestamp + "_"
                        + scenario.getName().replaceAll(" ", "_") + ".png");
                FileUtils.moveFile(srcFile, destFile);
                scenario.embed(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES), "image/png");
                logger.info("Screenshot taken: " + destFile.getAbsolutePath());
            }
        }
    }
}
