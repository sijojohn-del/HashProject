package com.share2people.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * This is the utility class for data read write
 *
 * @author Nimit Jain
 *
 */
public class DataReadWrite {

	/**
	 * readDataFromFile
	 *
	 * @param Property
	 * @return text
	 */
	public static String getProperty(String Property) {
		try {
			Properties prop = ResourceLoader.loadProperties("Config.properties");
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * This method will get the properties pulled from a file located relative to the base dir
	 * 
	 * @param propFile complete or relative (to base dir) file location of the properties file 
	 * @param Property property name for which value has to be fetched 
	 * @return String value of the property
	 */
	public static String getProperty(String propFile, String Property) {
		try {
			Properties prop = ResourceLoader.loadProperties(propFile);
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}    

	/**
	 * readXmlFromFile
	 *
	 * @param fileName
	 * @return text
	 */
	public static String readXmlFromFile(String fileName) {

		File file = new File(fileName);
		StringBuilder contents = new StringBuilder();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text;

			// repeat until all lines is read
			while ((text = reader.readLine()) != null) {
				contents.append(text).append(
						System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (contents.toString());
	}

	public static String readFile(String filePath) {
		BufferedReader reader = null;
		String line = null;
		StringBuilder stringBuilder = null;
		String ls = System.getProperty("line.separator");

		try {
			reader = new BufferedReader(new FileReader (filePath));
			stringBuilder = new StringBuilder();
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		return null;
	}

	public static void writeToFile(String filePath, String data) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			File file = new File(filePath);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bw!=null)
				try {
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}