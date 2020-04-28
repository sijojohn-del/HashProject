package com.share2people.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateHelper {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	

	public static String getDate(int minusDays)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.add(Calendar.DATE, minusDays);
		return dateFormat.format(cal.getTime());
	}
	
	public static String getcurrentDate(int minusDays)
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Get the first day of month
	 * @return
	 */
	public static String getFirstDayOfMonth(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Get the first day of month
	 * @return
	 */
	public static String getFirstDayOfWeek(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -cal.FRIDAY);
		return dateFormat.format(cal.getTime());
	}
	
	public static String getDate(String date){
		String returnDate = null;
		switch(date.toLowerCase()){
		case "today":
			returnDate = getDate(0);
			break;
		case "yesterday":
			returnDate = getDate(-1);
			break;
		case "last5":
			returnDate = getDate(-5);
			break;
		case "monthstart":
			returnDate = getFirstDayOfMonth();
			break;
		case "weekstart":
			returnDate =  getFirstDayOfWeek();
			break;
		case "lwstartdate":
			returnDate = LWStartDate();
			break;
		case "lwenddate":
			returnDate = LWEndDate();
			break;
		}
		return returnDate;
	}
	
	public static String LWStartDate()
	{	
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int i = cal.get(Calendar.DAY_OF_WEEK) - cal.getFirstDayOfWeek();
		cal.add(cal.DATE, -i-8);
		return dateformat.format(cal.getTime());
	}
	
	public static String LWEndDate()
	{	
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int i = cal.get(Calendar.DAY_OF_WEEK) - cal.getFirstDayOfWeek();
		cal.add(Calendar.DATE, -i-2);
		return dateformat.format(cal.getTime());

	}
	
	/**
	 * Method returns last week Saturday
	 * @return
	 */
	public String WTDStartDate()
	{
		Calendar cal = Calendar.getInstance();
		cal.add( Calendar.DAY_OF_WEEK, Calendar.SUNDAY-6);
		System.out.println(dateFormat.format(cal.getTime()));
		String WTDdate = dateFormat.format(cal.getTime());
		return WTDdate;
	}

	/**
	 * Method returns last day
	 * @return
	 */
	public String WTDEndDate()
	{
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		System.out.println(dateFormat.format(yesterday.getTime()));
		String yesterdayDate = dateFormat.format(yesterday.getTime());
		return yesterdayDate;
	}

	/**
	 * Method returns yesterday
	 * @return
	 */
	public String YesterdayDate()
	{
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		String yesterdayDate = dateFormat.format(yesterday.getTime());
		return yesterdayDate;
	}

	public String LWStartDay()
	{
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		int backDate = 0;
		switch (day) {
		case Calendar.SUNDAY:
			backDate = 7;
			System.out.println("Its sunday");
			break;
		case Calendar.MONDAY:
			backDate = 8;
			System.out.println("Its monday");
			break;
		case Calendar.TUESDAY:
			backDate = 11;
			System.out.println("Its tuesday");
			break;  
		case Calendar.WEDNESDAY:
			backDate = 12;
			System.out.println("Its friday");
			break;
		case Calendar.THURSDAY:
			backDate = 11;
			System.out.println("Its friday");
			break;
		case Calendar.FRIDAY:
			backDate = 12;
			System.out.println("Its friday");
			break;
		case Calendar.SATURDAY:
			backDate = 13;
			System.out.println("Its friday");
		}
		c.add(Calendar.DATE,-backDate+1);
		String date = dateFormat.format(c.getTime());
		System.out.println(dateFormat.format(c.getTime()));
		return date;

	}


	public String LWSLastDay()
	{
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day value is "+day);
		int backDate = 0;
		switch (day) {
		case Calendar.SUNDAY:
			backDate = 7;
			System.out.println("Its sunday");
			break;
		case Calendar.MONDAY:
			backDate = 8;
			System.out.println("Its monday");
			break;
		case Calendar.TUESDAY:
			backDate = 11;
			System.out.println("Its tuesday");
			break;
		case Calendar.WEDNESDAY:
			backDate = 12;
			System.out.println("Its ours friday");
			break;
		case Calendar.THURSDAY:
			backDate = 11;
			System.out.println("Its friday");
			break;  
		case Calendar.FRIDAY:
			backDate = 12;
			System.out.println("Its friday");
			break;
		case Calendar.SATURDAY:
			backDate = 13;
			System.out.println("Its friday");
		}
		c.add(Calendar.DATE,-backDate+7);
		String date = dateFormat.format(c.getTime());
		System.out.println(dateFormat.format(c.getTime()));
		return date;

	}

}
