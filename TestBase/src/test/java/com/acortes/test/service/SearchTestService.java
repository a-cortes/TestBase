package com.acortes.test.service;

import com.acortes.test.poms.GooglePage;
import com.acortes.utils.core.ConfigReader;
import com.acortes.utils.test.SeUtils;
import com.acortes.utils.test.Validations;

public class SearchTestService {
	public static boolean navigateToMain() {
		String url = ConfigReader.readPropByEnvironment("index");
		SeUtils.navigateTo(url);
		GooglePage page = GooglePage.getPage();	
		SeUtils.screenshot();
		return Validations.isVisible(page.getSearchBox());
	}
	
	public static boolean search(String text) {
		GooglePage page = GooglePage.getPage();	
		page.searchFor(text);
		return page.getResults().size()>0;		
	}

}
