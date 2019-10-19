package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelHelper extends GenericHelper {
	Workbook book;
	Sheet sh;

	// open excel to read the data
	public void openExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(getPath(folderName, fileName));
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// find number of rows
	public int getRows() {
		return sh.getRows();
	}

	// find number of columns
	public int getColumns() {
		return sh.getColumns();
	}

	// read data
	public String readData(int rnum, int cnum) {
		return sh.getCell(cnum, rnum).getContents();
	}

	// close file
	public void closeExcel() {
		book.close();
	}

	public String[][] readExcelData(String folderName, String fileName, String sheetName) {
		this.openExcel(folderName, fileName, sheetName);
		int rows = this.getRows();
		int columns = this.getColumns();
		String[][] data = new String[rows - 1][columns];
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				data[r - 1][c] = this.readData(r, c);
			}
		}
		this.closeExcel();
		return data;
	}

	/*public static void main(String[] args) {
		ExcelHelper excel = new ExcelHelper();
		String[][] roleData = excel.readExcelData("resources", "data.xls", "empdata");
		for (String[] row : roleData) {
			for (String cell : row) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
	}*/
}
