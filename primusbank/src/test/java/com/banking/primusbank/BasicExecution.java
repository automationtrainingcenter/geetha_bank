package com.banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {
	@BeforeClass(groups = {"empdd", "roledd", "login", "role", "branch", "employee", "reset", "cancel", "create"})
	public void launch() {
		driver = openBrowser("chrome");
		driver.get("http://primusbank.qedgetech.com/");
	}
	
	@AfterClass(groups = {"empdd", "roledd", "role", "branch", "employee", "reset", "cancel", "create"})
	public void close() {
		closeBroser();
	}
	

}
