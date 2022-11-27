package com.ecom.testcases;

import org.testng.annotations.Test;

public class RegressionTest {
	@Test(groups = {"regression"})
	public void house() {
		System.out.println("In house class testing");
	}	
	@Test(groups = {"regression"})	
	public void flat() {
		System.out.println("In flat class testing");
	}
	@Test(priority = 0,enabled = false)
	public void bridge() {
		System.out.println("In bridge class testing");
	}
	
	@Test
	public void road() {
		System.out.println("In road class testing");
	}
	@Test
	public void tunnel() {
		System.out.println("In tunnel class testing");
	}
}
