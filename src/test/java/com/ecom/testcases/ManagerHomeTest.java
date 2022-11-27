package com.ecom.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

public class ManagerHomeTest extends BaseClass {
	LoginPagePom loginPagePom;
	LoginTest loginTest;
	ExcelReader excelReader;
	Utility utility;
	ManagerHomePom managerHomePom;
	
	
	@BeforeClass
	public void setUp() {
		initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 2)
	public void testValidLogin() throws EncryptedDocumentException, IOException {
		SoftAssert softAssert=new SoftAssert();
		
		excelReader = new ExcelReader();
		Sheet sh=excelReader.getSheet("LoginPage");
		
		Map<String,Object> data=excelReader.getData(sh);
		loginPagePom=new LoginPagePom();
		
		loginPagePom.setLoginCredentials((String)data.get("UserID"),(String)data.get("Password")); 
		softAssert.assertEquals(data.get("UserID").toString(), "mngr266311");
		
		loginPagePom.clickLoginButton();
		softAssert.assertAll();
		
		utility.takeScreenShot("ValidLogin");
	}
	@Test(dependsOnGroups = "validLogin")
		public void testClickOnNewCustomer() {
		Utility.useImplicitWait();
		
		managerHomePom.clickOnNewCustomer();
		
	}
	

}
