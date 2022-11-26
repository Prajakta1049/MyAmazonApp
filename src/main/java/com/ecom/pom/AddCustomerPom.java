package com.ecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.base.BaseClass;

public class AddCustomerPom extends BaseClass {
	public AddCustomerPom() {
		PageFactory.initElements(driver, this);	
		
	}
	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName;
	
	@FindBy(linkText ="female")
	WebElement gender;
	
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dateOfBirth;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement telephoneNumber;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@name='res']")
	WebElement resetButton;
	
	public void fillUpForm(String name,String place,String area) {
		customerName.sendKeys(name);
		address.sendKeys(place);
		city.sendKeys(area);
		
	}
	public void clickOnSubmitButton() {
		submitButton.click();
		
		
	}
	
	
	
}
