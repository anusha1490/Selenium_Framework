package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderCLass1 {

	@DataProvider(name = "TC002")
	
	public static String[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream("./TestData/TC002.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		String[][] testdata = new String[rc][cc];

		for (int i = 1; i <= rc; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cc; j++) {
				String text = row.getCell(j).getStringCellValue();
				
				testdata[i-1][j] = text;
				System.out.println("The data at row "+i +" and column "+j+" is "+text);
			}
		}

		return testdata;

	}

}
