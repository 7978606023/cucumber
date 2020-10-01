package com.ip.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Entry point for running the Cucumber tests in JUnit.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:features/passengers_policy.feature"},
        glue = "classpath:com/ip/stepdefinition")
public class CucumberTest {

}
