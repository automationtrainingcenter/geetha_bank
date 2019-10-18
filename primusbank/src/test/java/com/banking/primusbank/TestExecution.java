package com.banking.primusbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {

	protected WebDriver driver;
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	private RoleCreationPage roleCreationPage;

	@Test(priority = 0, groups = {})
	public void loginTest() {
		bankHomePage = new BankHomePage(this.driver);
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isAdminHomePageDisplayed());
	}
	
	@Test(priority = 1, groups = {})
	public void roleCreationWithValidData() {
		adminHomePage.clickRoles();
		roleDetailsPage = PageFactory.initElements(driver, RoleDetailsPage.class);
		roleDetailsPage.clickNewRole();
		roleCreationPage = PageFactory.initElements(driver, RoleCreationPage.class);
		roleCreationPage.fillRoleName("newRoleTestNg");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickSubmit();
		Alert alert = this.driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.toLowerCase().contains("successfully"));
	}
}
