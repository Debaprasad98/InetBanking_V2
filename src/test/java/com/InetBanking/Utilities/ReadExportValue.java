package com.InetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadExportValue {
	Properties prop;
	public ReadExportValue() {
		try {
			FileInputStream fis=new FileInputStream("export.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Error occuring message for file"+e.getMessage());
		}catch(IOException e) {
			System.out.println("Error occuring message for properties file"+e.getMessage());
		}
	}
	
	public String getexportValue() {
		String exportval=prop.getProperty("customerid");
		return exportval;
	}
}
