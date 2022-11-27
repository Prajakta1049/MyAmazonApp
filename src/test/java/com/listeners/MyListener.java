package com.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ecom.utility.Utility;

public class MyListener implements ITestListener {
	@Override	
	public void onTestStart(ITestResult result) {
		    System.out.println(result.getName()+"Test case started");
		    
	  }
	public void onTestSuccess(ITestResult result) {
	try {
		Utility.takeScreenShot(result.getName());
	} 
	catch (IOException e) {		
		e.printStackTrace();
	}
	    
	  }
	public void onTestFailure(ITestResult result) {
		 System.out.println(result.getName()+"Test case failed");
	  }
}
