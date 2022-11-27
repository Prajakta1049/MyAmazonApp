package com.ecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.BaseClass;

public class EditCustomerPom extends BaseClass{
	public EditCustomerPom() {
		PageFactory.initElements(driver, this);	
		
		}
		@FindBy(linkText = "Edit Customer")
		WebElement editCustomer;
	
		@FindBy(xpath = "//input[@name='cusid']")			
		WebElement customerID;

		@FindBy(xpath = "//input[@name='AccSubmit']")			
		WebElement submitButton;
		
		@FindBy(xpath = "//input[@name='res']")			
		WebElement resetButton;

		public void setcustomerID(String name) {
			customerID.sendKeys(name);
			submitButton.click();
			
		}
		
}
