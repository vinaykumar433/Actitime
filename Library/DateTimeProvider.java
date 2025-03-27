package com.actitime.Library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeProvider
{
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	public static String getCurrentDayOfMonth()
	{
		LocalDateTime ldt=LocalDateTime.now();
		int day1 = ldt.getDayOfMonth();
		return Integer.toString(day1);
	}
	
	public static String getCurrentMonth()
	{
		LocalDateTime ldt=LocalDateTime.now();
		String month1 = ldt.getMonth().name();
		return month1.substring(0, 1).toUpperCase() + month1.substring(1).toLowerCase();
	}
	
	public static String getCurrentYear()
	{
		LocalDateTime ldt=LocalDateTime.now();
		int year1 = ldt.getYear();
		return Integer.toString(year1);
	
	}
	

}
