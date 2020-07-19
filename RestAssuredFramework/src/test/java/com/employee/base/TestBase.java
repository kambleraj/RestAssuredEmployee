package com.employee.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
  
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empid="51838";
	public Logger logger;
	@BeforeClass
	public void setUp()
	{
		logger=Logger.getLogger("Employerestapi");
		PropertyConfigurator.configure("Log4j.properties"); 
		logger.setLevel(Level.DEBUG);
	}
}
