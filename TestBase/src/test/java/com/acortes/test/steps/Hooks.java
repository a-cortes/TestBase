package com.acortes.test.steps;

import com.acortes.utils.test.ReportUtils;
import com.acortes.utils.test.SeUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	@Before()
	public void before(Scenario scenario) {
		ReportUtils.setScenario(scenario);
		System.out.println("SCENARIO STARTS :: " + scenario.getName());
	}

	@After()
	public void tearDown(Scenario scenario) {	
		System.out.println("SCENARIO ENDS :: " + scenario.getName());
		if (SeUtils.isDriverActive()) {
			if (scenario.isFailed()) {
				ReportUtils.takeScreenshot();
			}
			SeUtils.getDriver().quit();
		}
	}
}
