package com.InetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig() {
		try {
			FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Error occuring message for File"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occuring message for properties file"+e.getMessage());
		}

	}
	public String geturl() {
		String url=prop.getProperty("baseURL");
		return url;
	}

	public String getusername() {
		String username=prop.getProperty("username");
		return username;
	}
	public String getpassword() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getbrowser() {
		String browser=prop.getProperty("browser");
		return browser;
	}
}
