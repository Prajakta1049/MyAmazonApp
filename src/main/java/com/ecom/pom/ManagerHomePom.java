package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.BaseClass;

public class ManagerHomePom extends BaseClass{
public ManagerHomePom() {
	PageFactory.initElements(driver, this);	
	
	}

	@FindBy(xpath = "//a[@href='addcustomerpage.php']")			
	WebElement newCustomer;

	@FindBy(xpath = "//a[@href='EditCustomer.php']"	)			
	WebElement editCustomer;
	
	@FindBy(linkText = "Delete Customer")			
	WebElement deleteCustomer;
	
	@FindBy(linkText = "New Account")				
	WebElement newAccount;
	
	@FindBy(linkText = "Edit Account")				
	WebElement editAccount;
	
	@FindBy(linkText = "Delete Account")			//a[text()='Delete Account']
	WebElement deleteAccount;
	
	@FindBy(linkText = "Mini Statement")			//a[text()='Mini Statement']
	WebElement miniStatement;
	
	@FindBy(linkText = "Customised Statement")		//a[text()='Customised Statement']
	WebElement customisedStatement;
	
	@FindBy(linkText = "Log out")					//a[text()='Log out']
	WebElement logOut;
	
	public AddCustomerPom clickOnNewCustomer() {
		newCustomer.click();
		return new AddCustomerPom();
	}

	public void clickOnEditCustomer() {
		editCustomer.click();
		
	}
}


