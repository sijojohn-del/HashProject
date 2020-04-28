package com.share2people.utils;


import java.text.ParseException;

public class TimeConverter {

	public static int getSecondsFromString(String timestring) throws ParseException{
		String mi=timestring.substring(0, timestring.indexOf(":"));
		String sec=timestring.substring(timestring.indexOf(":")+":".length());
		int inSec=Integer.parseInt(mi)*60+Integer.parseInt(sec);
		System.out.println("Converted elapsed time in seconds");
		return inSec;
	}
}
