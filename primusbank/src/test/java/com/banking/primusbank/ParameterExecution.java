package com.banking.primusbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {
	@BeforeClass(groups = { "empdd", "roledd", "login", "role", "branch", "employee", "reset", "cancel", "create" })
	@Parameters({ "browserName", "url" })
	public void launch(String brName, String url) {
		driver = openBrowser(brName);
		driver.get(url);
	}

	@AfterClass(groups = { "empdd", "roledd", "login", "role", "branch", "employee", "reset", "cancel", "create" })
	public void close() {
		closeBroser();
	}

}
