package com.ecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.base.BaseClass;
import com.ecom.pom.AddCustomerPom;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

public class AddCustomerTest extends BaseClass {
	LoginPagePom loginPagePom;
	LoginTest loginTest;
	AddCustomerPom addCustomerPom;
	ExcelReader excelReader;
	Utility utility;
	
	@BeforeClass
	public void setUp() {
		initDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 0)
	public void fillFormTitle() {
		utility = new Utility();
		String title=utility.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "GTPL Bank Manager HomePage");
		}
	
	@Test(priority = 1)
		public void fillDataForm() throws EncryptedDocumentException, IOException {
			SoftAssert softAssert=new SoftAssert();
			
			excelReader = new ExcelReader();
			Sheet sh=excelReader.getSheet("LoginPage");
			Map<String,Object> data= excelReader.getData(sh);
			loginPagePom=new LoginPagePom();
			loginPagePom.setLoginCredentials((String)data.get("UserID"),(String)data.get("Password")); 
			softAssert.assertEquals(data.get("UserID").toString(), "mngr266311");
			loginPagePom.clickLoginButton();
			softAssert.assertAll();
			Sheet sh1=excelReader.getSheet("NewCustomer");
			Map<String,Object> info= excelReader.getData(sh1);
			addCustomerPom = new AddCustomerPom();
			addCustomerPom.fillUpForm((String)info.get("CustomerName"),(String) info.get("Address"),(String)info.get("City"));	
			addCustomerPom.clickOnSubmitButton();
			utility.takeScreenShot("Manager page");
		}
		//public void clickOnSubmitButton() {}
			
		
	
}	
