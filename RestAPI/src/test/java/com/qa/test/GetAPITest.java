package com.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	
	
	TestBase base;
	public String apiUrl;
	public String sericeUrl;
	
	public String url;
	
	@BeforeMethod
	public void setUp() {
		base=new TestBase();
		String apiUrl=prop.getProperty("URL");
		String sericeUrl=prop.getProperty("ServiceURL");
		
		url=apiUrl+sericeUrl;
		
		
	}
	
	@Test
	public void getTest() {
RestClient client=new RestClient();
		
		client.getMethod(url);
	}

}
