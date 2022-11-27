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
import com.ecom.pom.AddCustomerPom;
import com.ecom.pom.EditCustomerPom;
import com.ecom.pom.LoginPagePom;
import com.ecom.pom.ManagerHomePom;
import com.ecom.utility.ExcelReader;
import com.ecom.utility.Utility;

public class EditCustomerTest extends BaseClass{
	LoginPagePom loginPagePom;
	LoginTest loginTest;
	ManagerHomePom managerHomePom;
	AddCustomerPom addCustomerPom;
	EditCustomerPom editCustomerPom;
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
	public void testPageTittle() {
		utility = new Utility();
		String title=utility.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "GTPL Bank Manager HomePage");
	}
	
	@Test(priority = 1)
		public void testValidID() throws EncryptedDocumentException, IOException {
			SoftAssert softAssert=new SoftAssert();
			
			excelReader = new ExcelReader();
			Sheet sh=excelReader.getSheet("LoginPage");
			
			Map<String,Object> data= excelReader.getData(sh);
			loginPagePom=new LoginPagePom();
			
			loginPagePom.setLoginCredentials((String)data.get("UserID"),(String)data.get("Password"));
			
			softAssert.assertEquals(data.get("UserID").toString(), "mngr266311");
			
			loginPagePom.clickLoginButton();
			softAssert.assertAll();
			
			managerHomePom.clickOnEditCustomer();
						
			Sheet sh2=excelReader.getSheet("CustomerID");
			String id=excelReader.getSingleData(sh, 1, 0).toString();
			System.out.println(id);
			
			editCustomerPom = new EditCustomerPom();
			editCustomerPom.setcustomerID(sh.getRow(1).getCell(0).getStringCellValue());
			
			System.out.println(sh);
			
			Utility.takeScreenShot("Edit customer");
		}

}
