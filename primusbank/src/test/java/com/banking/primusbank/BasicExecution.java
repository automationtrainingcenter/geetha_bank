package com.banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {
	@BeforeClass
	public void launch() {
		driver = openBrowser("chrome");
		driver.get("http://primusbank.qedgetech.com/");
	}
	
	@AfterClass
	public void close() {
		closeBroser();
	}
	

}
