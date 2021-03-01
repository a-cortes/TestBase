package com.acortes.utils.core;

import javax.xml.ws.Response;
import com.jayway.restassured.RestAssured;

public class RestUtils {
	
	public static Response post(String uri) {
		RestAssured.given()
	    .when()
	    .get(uri);
		
		return null;
	}

}
