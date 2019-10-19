package com.banking.primusbank;

import static org.testng.Assert.assertTrue;

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
	private com.banking.primusbank.BranchDetailsPage branchDetailsPage;
	private BranchCreationPage branchCreationPage;
	private EmployeeDetailsPage employeeDetailsPage;
	private EmployeeCreationPage employeeCreationPage;

	@Test(priority = 0, groups = {"empdd", "roledd", "login", "role", "branch", "employee", "reset", "cancel", "create" })
	public void loginTest() {
		bankHomePage = new BankHomePage(this.driver);
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLoginButton();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.isAdminHomePageDisplayed());
	}

	@Test(priority = 1, groups = { "role", "create" }, dependsOnMethods = { "loginTest" })
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

	@Test(priority = 2, groups = { "role", "reset" })
	public void roleCreationReset() {
		adminHomePage.clickRoles();
		roleDetailsPage = PageFactory.initElements(driver, RoleDetailsPage.class);
		roleDetailsPage.clickNewRole();
		roleCreationPage = PageFactory.initElements(driver, RoleCreationPage.class);
		roleCreationPage.fillRoleName("newRoleTestNg");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isFormReset());
	}

	@Test(priority = 3, groups = { "role", "cancel" })
	public void roleCreartionCancel() {
		adminHomePage.clickRoles();
		roleDetailsPage = PageFactory.initElements(driver, RoleDetailsPage.class);
		roleDetailsPage.clickNewRole();
		roleCreationPage = PageFactory.initElements(driver, RoleCreationPage.class);
		roleCreationPage.clickCancel();
		roleDetailsPage = PageFactory.initElements(driver, RoleDetailsPage.class);
		Assert.assertTrue(roleDetailsPage.isThisPageDisplayed());
	}

	@Test(priority = 4, groups = { "branch", "create" })
	public void branchCreationWithValidData() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickBranches();
		branchDetailsPage = PageFactory.initElements(driver, BranchDetailsPage.class);
		branchDetailsPage.clickNewbranch();
		branchCreationPage = PageFactory.initElements(driver, BranchCreationPage.class);
		branchCreationPage.fillbranchName("newBranchTestNg");
		branchCreationPage.fillAdress1("adfakjhfka");
		branchCreationPage.fillZipcode("54321");
		branchCreationPage.selectcountry("USA");
		branchCreationPage.selectstate("NewYork");
		branchCreationPage.selectcity("Rochestor");
		branchCreationPage.clickSubmit();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.contains("successfully"));
	}

	@Test(priority = 5, groups = { "branch", "reset" })
	public void branchCreationReset() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickBranches();
		branchDetailsPage = PageFactory.initElements(driver, BranchDetailsPage.class);
		branchDetailsPage.clickNewbranch();
		branchCreationPage = PageFactory.initElements(driver, BranchCreationPage.class);
		branchCreationPage.fillbranchName("newBranchTestNg");
		branchCreationPage.fillAdress1("adfakjhfka");
		branchCreationPage.fillZipcode("54321");
		branchCreationPage.selectcountry("USA");
		branchCreationPage.selectstate("NewYork");
		branchCreationPage.selectcity("Rochestor");
		branchCreationPage.clickReset();
		Assert.assertTrue(branchCreationPage.isFromReset());
	}

	@Test(priority = 6, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickBranches();
		branchDetailsPage = PageFactory.initElements(driver, BranchDetailsPage.class);
		branchDetailsPage.clickNewbranch();
		branchCreationPage = PageFactory.initElements(driver, BranchCreationPage.class);
		branchCreationPage.clickCancel();
		branchDetailsPage = PageFactory.initElements(driver, BranchDetailsPage.class);
		Assert.assertTrue(branchDetailsPage.isThisPageDisplayed());
	}

	@Test(priority = 7, groups = { "employee", "create" })
	public void employeeCreationWithValidData() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickEmployees();
		employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
		employeeDetailsPage.clickNewEmployee();
		employeeCreationPage = PageFactory.initElements(driver, EmployeeCreationPage.class);
		employeeCreationPage.fillEmployerName("newTestNGEmp");
		employeeCreationPage.fillLoginpassword("dummy");
		employeeCreationPage.selectBranchType("newBranchTestNg");
		employeeCreationPage.selectRoleType("newRoleTestNg");
		employeeCreationPage.clickSubmit();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		Assert.assertTrue(text.contains("successfully"));
	}

	@Test(priority = 8, groups = { "employee", "reset" })
	public void employeeCreationReset() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickEmployees();
		employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
		employeeDetailsPage.clickNewEmployee();
		employeeCreationPage = PageFactory.initElements(driver, EmployeeCreationPage.class);
		employeeCreationPage.fillEmployerName("newTestNGEmp");
		employeeCreationPage.fillLoginpassword("dummy");
		employeeCreationPage.selectBranchType("newBranchTestNg");
		employeeCreationPage.selectRoleType("newRoleTestNg");
		employeeCreationPage.clickReset();
		Assert.assertTrue(employeeCreationPage.isFormReset());
	}

	@Test(priority = 9, groups = { "employee", "cancel" })
	public void employeeCreationCancel() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickEmployees();
		employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
		employeeDetailsPage.clickNewEmployee();
		employeeCreationPage = PageFactory.initElements(driver, EmployeeCreationPage.class);
		employeeCreationPage.clickCancel();
		employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
		Assert.assertTrue(employeeDetailsPage.isThisPageDisplayed());
	}

	@Test(priority = 10, groups = { "roledd" }, dataProviderClass = TestDataProvider.class, dataProvider = "roleData")
	public void roleCreationResetWithMultipleData(String roleName, String roleType) {
		adminHomePage.clickRoles();
		roleDetailsPage = PageFactory.initElements(driver, RoleDetailsPage.class);
		roleDetailsPage.clickNewRole();
		roleCreationPage = PageFactory.initElements(driver, RoleCreationPage.class);
		roleCreationPage.fillRoleName(roleName);
		roleCreationPage.selectRoleType(roleType);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isFormReset());
	}

	@Test(priority = 11, groups = { "empdd" }, dataProviderClass = TestDataProvider.class, dataProvider = "empData")
	public void employeeCreationResetWithMultipleData(String empName, String pass, String roleType, String brachType) {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		adminHomePage.clickEmployees();
		employeeDetailsPage = PageFactory.initElements(driver, EmployeeDetailsPage.class);
		employeeDetailsPage.clickNewEmployee();
		employeeCreationPage = PageFactory.initElements(driver, EmployeeCreationPage.class);
		employeeCreationPage.fillEmployerName(empName);
		employeeCreationPage.fillLoginpassword(pass);
		employeeCreationPage.selectBranchType(brachType);
		employeeCreationPage.selectRoleType(roleType);
		employeeCreationPage.clickReset();
		Assert.assertTrue(employeeCreationPage.isFormReset());
	}

}
