package com.acortes.test.steps;

import org.junit.Assert;

import com.acortes.test.poms.GooglePage;
import com.acortes.test.service.SearchTestService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FeatureSteps {
	
	@Given("^User Navigates to main page$")
	public void user_Navigates_to_main_page() throws Throwable {
	    SearchTestService.navigateToMain();
	}

	@When("^User search for \"([^\"]*)\"$")
	public void user_search_for(String text) throws Throwable {
		SearchTestService.search(text);
	}

	@Then("^Validate number of \"([^\"]*)\"$")
	public void validate_number_of(String size) throws Throwable {
		GooglePage page = GooglePage.getPage();
		Assert.assertEquals(size, ""+page.getResults().size() );
	}	

}
