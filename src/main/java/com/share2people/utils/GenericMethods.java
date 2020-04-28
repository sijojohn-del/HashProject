package com.share2people.utils;

public class GenericMethods {
	
	/**
	 * Checking whether string is json
	 * @param string
	 * @return
	 */
	public static boolean isStringJson(String string) {
		Boolean flag;
		if(string.substring(0,1).equals("{")||string.substring(0,1).equals("[")){
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * Checking whether string is xml
	 * @param string
	 * @return
	 */
	public static boolean isStringXml(String string) {
		Boolean flag;
		if(string.substring(0,1).equals("<")){
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
}
