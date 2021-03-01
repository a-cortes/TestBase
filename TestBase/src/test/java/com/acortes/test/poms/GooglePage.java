package com.acortes.test.poms;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acortes.utils.test.SeUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GooglePage {

	static GooglePage page;

	public static GooglePage getPage() {
		//if(page==null)
		page = PageFactory.initElements(SeUtils.getDriver(), GooglePage.class);
		return page;
	}

	@FindBy(xpath = "//input[contains(@title,'Buscar')]")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@id ='search']//h3[not(ancestor::*[@class='xpdopen'])]")
	private List<WebElement> results;

	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
	}
}
