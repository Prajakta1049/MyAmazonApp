package com.ecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecom.base.BaseClass;
import com.ecom.pom.LoginPagePom;
import com.ecom.utility.ExelReader;


public class LoginTest extends BaseClass {
	LoginPagePom loginPagePom;
	ExelReader exelReader;
	@BeforeClass
	public void setUp() {
		initDriver();
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testLogin() throws EncryptedDocumentException, IOException {
		exelReader = new ExelReader();
		Sheet sh=exelReader.getSheet("LoginPage");
		Map<String,Object> data=exelReader.getData(sh);
		loginPagePom=new LoginPagePom();
		loginPagePom.loginWithValidCredentials((String)data.get("UserID"),(String)data.get("Password")); 
	
		
	}
}
	
