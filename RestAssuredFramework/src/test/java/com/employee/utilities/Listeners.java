package com.employee.utilities;

//listener clas to generate extent reports
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listeners extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
public void onStart(ITestContext testcontext)
{

htmlReporter=new ExtentHtmlReporter(System.getProperty("user-dir")+"/Reports/myreport.html");
htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
extent= new ExtentReports();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("Host name","localhost" );
extent.setSystemInfo("Environment","QA");
extent.setSystemInfo("user", "rajendra");
htmlReporter.config().setDocumentTitle("Testproject");
htmlReporter.config().setReportName("Functional Test project");


}

public void OnTestSuccess(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	
}

public void onTestFailure(ITestResult tr)
{
logger=extent.createTest(tr.getName())	;
logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
String screenshotpath=System.getProperty("user.dir"+"\\screenshots\\"+tr.getName()+".png");
File f= new File(screenshotpath);

if (f.exists())
{
try {
	logger.fail("screenshot is below"+logger.addScreenCaptureFromPath(screenshotpath));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



}
}
public void onTestSkipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName())	;
	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
}
public void onFinish(ITestContext testcontext)
{
extent.flush();	
}


}

