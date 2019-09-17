package com.qa.client;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestClient {
	
	//get method
	public void getMethod(String url) {
		
		RequestSpecification request=RestAssured.given();
		
		Response resp=request.get(url);
		int code=resp.getStatusCode();
		System.out.println("Status code is : "+code);
		
		Assert.assertEquals(200, code);
		
		System.out.println("This is the response from get call : "+resp.getBody().asString());
		
		System.out.println("response in json format :--- "+resp.jsonPath().prettify());
		
		Headers headerArray=resp.getHeaders();
		
		HashMap<String, String> headersMap=new HashMap<String, String>();
		
		for(Header header:headerArray) {
			headersMap.put(header.getName(), header.getValue());
		}
		
		System.out.println("All headers are "+headersMap);
	}

}
