package com.ecom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static String projectPath =System.getProperty("user.dir");;
	public static WebDriver driver;
	
	@BeforeMethod
	public static void initDriver() {
		//System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
	}

}
