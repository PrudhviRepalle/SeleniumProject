 package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcel {
	
	@DataProvider(name =  "IRCTC", parallel = true)
	
	public static String[][] readData() throws IOException {

		FileInputStream fis = new FileInputStream("./TestData/TC001.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		String[][] testdata = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {

			Row row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				String data = row.getCell(j).getStringCellValue();
				testdata[i-1][j] = data;
				System.out.println("Row "+(i-1)+" - col "+j+" "+data);
			}
		}
		return testdata;
	}

}
