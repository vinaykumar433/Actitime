package com.actitime.Library;

import org.apache.commons.lang3.RandomStringUtils;

import net.bytebuddy.utility.RandomString;

public class RandomStringProvider
{
	public static String getRandomString() 
	  { 
		  return RandomStringUtils.randomAlphabetic(8); 
	  }
	
	public static String getRandomNumeric() 
	  { 
		  return RandomStringUtils.randomNumeric(3); 
	  }
}




//we can also use RandomString.make(8);
