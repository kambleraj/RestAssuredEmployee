package com.employee.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC_GET_GetAllEmployees  extends TestBase{


	@BeforeClass
	public void getAllEmployees() throws InterruptedException
	{
		logger.info("----Started first test case----");
		RestAssured.baseURI="dummy.restapiexample.com/api/v1";
		httpRequest= RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3000);

	}

	@Test
	public void checkResponseBody()
	{

		logger.info("------checking response body-----");
		String responseBody=response.getBody().asString();
		logger.info("Response body is--->"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}



	@Test
	public void checkStatusCode()
	{

		logger.info("------checking Statuscode-----");
		int statusCode=response.getStatusCode();
		logger.info("Response code is--->"+statusCode);
		Assert.assertEquals(statusCode,200);
	}
	
	
	@Test
	public void checkResponseTime()
	{
		
		logger.info("-----checking response time-----");
		long responseTime=response.getTime();
		logger.info("Response time is---->"+responseTime);
		Assert.assertTrue(responseTime<2000);
	}
	
	
	@Test
	public void checkStatusLine()
	{

		logger.info("------checking StatusLine-----");
		String statusLine=response.getStatusLine();
		logger.info("status line is--->"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	

	@Test
	public void checkContentType()
	{

		logger.info("------checking ContentType-----");
		String contentType=response.getHeader("Content-Type");
		logger.info("content type is--->"+contentType);
		Assert.assertEquals(contentType,"text/html;charset=UTF 8");
	}
	
	

	@Test
	public void checkServerType()
	{

		logger.info("------checking Seerver Type-----");
		String serverType=response.getHeader("Server");
		logger.info("server type is--->"+serverType);
		Assert.assertEquals(serverType,"nginx/1.14.1");
	}
	//content-Encoding and Content length----These are additional heders.
	
	@AfterClass
	void tearDown()
	{
		
		logger.info("-----finished getAllEmployees TC---");
	}
}
