package com.ecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;
import com.listeners.MyListener;

@Listeners(MyListener.class) 
public class LoginTest extends BaseClass {
	LoginPagePom loginPagePom;
	ExcelReader excelReader;
	Utility utility;
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports ;
	ExtentTest logger;
	
	@BeforeClass
	public void setUp() {
		initDriver();
		extentSparkReporter= new ExtentSparkReporter(projectPath+"//extentReport//testReport.html"); 
		extentReports= new ExtentReports();
		extentReports.attachReporter(extentSparkReporter); 
		}
	
	@AfterClass
	public void tearDown() {
		extentReports.flush();
		driver.quit();
	}
	
	@Test(priority = 1)
	public void testpageTitle() throws IOException {
		logger = extentReports.createTest("testPageTitle ");
		utility = new Utility();
		String title=utility.getTitle();
			//System.out.println(title);
		//utility.takeScreenShot("homepage");	//taking screenshot of homepage,taken in listener
		Assert.assertEquals(title, "GTPL Bank Home page");
	
	
	}	
	@Test(groups = {"validLogin"})
	public void testValidLogin() throws EncryptedDocumentException, IOException {
		logger = extentReports.createTest("testPageTitle ");
		SoftAssert softAssert=new SoftAssert();
		
		excelReader = new ExcelReader();
		Sheet sh=excelReader.getSheet("LoginPage");
		
		Map<String,Object> data=excelReader.getData(sh);
		
		loginPagePom=new LoginPagePom();
		
		loginPagePom.setLoginCredentials((String)data.get("UserID"),(String)data.get("Password"));
		
		softAssert.assertEquals(data.get("UserID").toString(), "mngr266311");
		
		loginPagePom.clickLoginButton();
		
		softAssert.assertAll();
		
		utility.useImplicitWait();
		
	}
}
	
