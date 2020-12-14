package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
           plugin = {"pretty",
            "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
            "rerun:target/cucumber-reports/rerun-reports/rerun.txt"},
            glue={"com.stepdefn","com.hooks"},
            features = {"src/test/resources/Features"}
    )
    public class CalculatorRunner {

    }


