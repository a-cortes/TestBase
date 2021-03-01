package com.acortes.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "com.acortes.test.steps", monochrome = true, tags = {
		"@SearchTest" }, plugin = { "json:target/Reports/JSON/results.json" })
public class TestRunner {

}
