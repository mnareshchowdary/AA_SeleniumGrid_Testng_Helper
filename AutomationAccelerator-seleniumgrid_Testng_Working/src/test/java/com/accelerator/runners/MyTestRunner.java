package com.accelerator.runners;

//import org.junit.runner.RunWith;

import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"com.accelerator.stepdefinitions", "com.accelerator.hooks"},
      plugin = {"pretty","html:test-output_1",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "json:target/cucumber.json"},
       	monochrome= true,
        dryRun= false
)

public class MyTestRunner extends AbstractTestNGCucumberTests {
	
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}