package edu.functionalconcepts;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static Object[][] excelRead(String fileName) throws IOException {
		
		// step1: set up the excel document path
		FileInputStream fis =new FileInputStream(fileName);
		//FileInputStream fis =new FileInputStream("./testdata/sampleTestdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		// step2: set up the worksheet
		XSSFSheet ws=wb.getSheet("shee1t");
		
		// to find the number of rows in the worksheet
		int rowCount=ws.getLastRowNum();
	
		// to find the number of cells in a row
		int cellCount=ws.getRow(1).getLastCellNum();
		
		// declare 2D array
		Object[][]data=new String [rowCount][cellCount];{
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String text=ws.getRow(j).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j]=text;
			}
		}
		}
		//close the work book
		wb.close();
		return data;
		
		
		
	
	}

}
