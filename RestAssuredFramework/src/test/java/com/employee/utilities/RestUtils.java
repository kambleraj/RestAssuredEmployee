package com.employee.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class RestUtils {
 
	public static String empName()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	
	public static String empSal()
	{
		
		String generatedString=RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	public static String empAge()
	{
		
		String generatedString=RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
	
}
