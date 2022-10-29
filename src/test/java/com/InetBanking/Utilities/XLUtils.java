package com.InetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {


	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	static String path;

	public XLUtils(String path){
		this.path=path;
	}



	public static int getRowCount(String xlsheet) throws IOException 
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}


	public static int getCellCount(String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}


	public static String getCellData(String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
}
