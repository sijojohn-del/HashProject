package com.share2people.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class FileHandler {
	
	/**
	 * Method to read file to string 
	 * @param srcFilePath
	 * @return
	 * @throws IOException
	 */
	public static String readFileToString(String srcFilePath) throws IOException {
		String fileString;
		fileString = FileUtils.readFileToString(new File(srcFilePath));
		return fileString;
	}
	
	
	/**
	 * Method to copy a file
	 * @param srcFilePath
	 * @param destFilePath
	 */
	public static void copyFile(String srcFilePath, String destFilePath) {
		File srcFile = null;
		File destFile = null;
		try {
			srcFile = new File(srcFilePath);
			destFile = new File(destFilePath);
			if(srcFile.exists() && srcFile.isFile()){
				FileUtils.copyFile(srcFile, destFile);
				System.out.println();
			} else {
				Assert.fail("Invalid Source file path while copy: "+srcFilePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to delete a file
	 * @param srcFilePath
	 */
	public static void deleteFile(String srcFilePath) {
		try {
			File srcFile = new File(srcFilePath);
			if(srcFile.exists() && srcFile.isFile()){
				FileUtils.forceDelete(srcFile);
				System.out.println(srcFile.getName() + " has been deleted successfully.");
			} else {
				Assert.fail("Invalid Source file path while delete: "+srcFilePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to clear a file without deleting it
	 * @param srcFilePath
	 */
	public static void clearFile(String srcFilePath) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(srcFilePath);
			writer.print("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	/**
	 * Method to output fileName without extension
	 * @param fileName
	 * @return fileName without extension
	 */
	public static String extractFilenameWithoutExtension(String fileName) {
		String[] tokenisedName = fileName.split("\\.");
		return tokenisedName[0];
	}
	
	/**
	 * Method to clean directory i.e deleteting all files from directory
	 * @param directoryPath
	 */
	public static void cleanDiectory(String directoryPath) {
		try {
			File directory = new File(directoryPath);
			if(directory.isDirectory()){
				FileUtils.cleanDirectory(directory);
				System.out.println(directory + "has been cleared.");
			} else {
				Assert.fail("Invalid directory path while clearing: "+directoryPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
