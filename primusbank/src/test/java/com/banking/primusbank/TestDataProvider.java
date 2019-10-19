package com.banking.primusbank;

import org.testng.annotations.DataProvider;

import utilities.ExcelHelper;

public class TestDataProvider {

	@DataProvider(name = "roleData")
	public Object[][] getRoleData() {
		ExcelHelper excel = new ExcelHelper();
		return excel.readExcelData("resources", "data.xls", "roledata");
	}

	@DataProvider(name = "empData")
	public Object[][] getEmpData() {
		ExcelHelper excel = new ExcelHelper();
		return excel.readExcelData("resources", "data.xls", "empdata");
	}

}
