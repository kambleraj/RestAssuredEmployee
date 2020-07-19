package com.employee.testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC_CreateEmploye_Post extends TestBase {

	String empname=RestUtils.empName();
	String empsal=RestUtils.empSal();
	String empage=RestUtils.empAge();


	@BeforeClass
	public void createEmployee() throws InterruptedException
	{

		logger.info("------Create employe started---");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		JSONObject requestparam= new JSONObject();
		requestparam.put("name",empname);
		requestparam.put("salary",empsal);
		requestparam.put("age",empage);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparam.toJSONString());
		response=httpRequest.request(Method.POST,"/create");
		Thread.sleep(30000);

	}

	@Test
	public void checkResposeBody()
	{

		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empname),true);  
		//.....
	}
	//...other verification point like content type, status code-201, status line or time

	@AfterClass
	public void teadDown()
	{

		logger.info("create---done");
	}
}
