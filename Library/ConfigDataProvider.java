package com.actitime.Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ConfigDataProvider
{
	public static String getValueFromPropertiesFile(String path, String key)
	{
		String value="";
		try
		{
			FileInputStream fin=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(fin);
			value=prop.getProperty(key);
		}
		catch(IOException e)
		{
			Reporter.log("Not able to read Data", true);
		}
		return value;
	}
	

}
