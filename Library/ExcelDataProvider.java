package com.actitime.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelDataProvider
{
	public static String getStringValue(String path, String sheetName, int r, int c)
	{
		String value="";
		try 
		{
			FileInputStream fin = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fin);
			value=wb.getSheet(sheetName).getRow(r).getCell(c).getStringCellValue();
		}
		catch(IOException e)
		{
			Reporter.log("Not able to read Data", true);
		}
		return value;
	}
	
	public static double getNumericValue(String path, String sheetName, int r, int c)
	{
		double value=0;
		try 
		{
			FileInputStream fin = new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fin);
			value=wb.getSheet(sheetName).getRow(r).getCell(c).getNumericCellValue();
		}
		catch(IOException e)
		{
			Reporter.log("Not able to read Data", true);
		}
		return value;
	}
	
	
	public static Object[][] getDataFromExcel(String path, String sheetName )
	{
		Object[][] arr=null;
		
		try
		{
			File file = new File(path);
			FileInputStream fin=new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fin);
			Sheet sheet=wb.getSheet(sheetName);
			arr = new Object[sheet.getPhysicalNumberOfRows()][3];
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
			{
				for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) 
				{
					arr[i][j]=sheet.getRow(i).getCell(j).toString();
				}
			
			}
		}
			catch(Exception e)
			{
				Reporter.log("Not able to read Data", true);
			}
			
			return arr;
		}
	
	public static String getDataByColumnName(String sheetName, String columnname) throws IOException
	{
		List<String> list=new ArrayList();
		
		String path=IAutoConstants.XL_PATH;
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0);
		HashMap <Integer, String> hm=new HashMap();
		for( )
		{
			
		}
		return null;
		
	}
}
