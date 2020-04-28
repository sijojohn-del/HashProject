/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share2people.utils;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;;

@SuppressWarnings("unchecked")
public class YamlHandler {

	public String yamlFilesPath;
	public String dynamicYamlFilePath;
	static String tier;

	/**
	 * Constructor to set yaml file path
	 * @param yamlPath
	 */
	public YamlHandler(String yamlPath) {
		yamlFilesPath = yamlPath;
	}



	/**
	 * Get yaml string value from a yaml file
	 * @param token
	 * @return
	 */
	public String getData(String token) {
		try {
			return getValue(token);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param token
	 * @param replacevalue
	 * @return
	 */
	public String getDataWithReplacement(String token , String replacevalue){
		String value = getData(token);
		if(value.contains("$"))
			value = value.replaceAll("\\$\\{.+?\\}", replacevalue);
		return value;
	}
	
	public Map<String, Object> getYamlValues(String token) {
		Reader doc;
		try {
			doc = new FileReader(yamlFilesPath);
		} catch (FileNotFoundException ex) {
			System.out.println("File not valid or missing!!!");
			ex.printStackTrace();
			return null;
		}
		Yaml yaml = new Yaml();
		// TODO: check the type casting of object into the Map and create
		// instance in one place
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return parseMap(object, token + ".");
	}

	public ArrayList<String> getYamlList(String token) {
		String[] dataList = (getData(token)).split(" ");
		ArrayList<String> list = new ArrayList<String>();
		for(String element : dataList){
			list.add(element);
		}
		return list;
	}

	public ArrayList<Integer> getYamlListForIntegers(String token) {
		String[] dataList = (getData(token)).split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String element : dataList){
			list.add(Integer.parseInt(element));
		}
		return list;
	}

	private String getValue(String token) throws FileNotFoundException {
		Reader doc = new FileReader(yamlFilesPath);
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return getMapValue(object, token);

	}

	public static String getMapValue(Map<String, Object> object, String token) {
		// TODO: check for proper yaml token string based on presence of '.'
		String[] st = token.split("\\.");
		return parseMap(object, token).get(st[st.length - 1]).toString();
	}

	private static Map<String, Object> parseMap(Map<String, Object> object,
			String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(st[0]),
					token.replace(st[0] + ".", ""));
		}
		return object;
	}

	/**
	 * Method to write data to yaml
	 * @param data
	 */
	public void writeDataToYaml(String yamlFilePath, Map<String, Object> data) {
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		Yaml yaml = new Yaml();
		FileWriter writer=null;
		try {
			writer = new FileWriter(yamlFilePath);
			yaml.dump(data, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Modify a map containing list under a token
	 * @param token
	 * @param value
	 * @param map
	 * @return
	 */
	private Map<String, Object> appendDataToMapContainingList(String token, String value, Map<String, Object> map) {
		if(map != null){
			if(map.containsKey(token)){
				if(map.get(token)!=null){
					Object obj = map.get(token);	
					System.out.println(obj.getClass());
					if(obj instanceof List){
						((List<String>) obj).add(value);
						map.put(token, (List<String>) obj);
					} else if(obj instanceof String) {
						List<String> list = getDynamicYamlList(token);
						list.add(value);
						map.put(token, list);
					}
				}
			} else{
				List<String> list = new ArrayList<String>();
				list.add(value);
				map.put(token, list);
			}
		} else{
			map = new HashMap<String, Object>();
			map.put(token, value);
		}
		return map;
	}

	/**
	 * Method to append data to list present in dynamic yaml
	 * @param token
	 * @param value
	 */
	public void appendDatatoDynamicYamlList(String token, String value) {
		try {
			Reader doc = new FileReader(yamlFilesPath);
			Yaml yaml = new Yaml();
			Map<String, Object> map = (Map<String, Object>) yaml.load(doc);
			map = appendDataToMapContainingList(token, value, map);
			writeDataToDynamicYaml(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to write data to dynamic yaml
	 * @param data
	 */
	public void writeDataToDynamicYaml(Map<String, Object> data) {
		writeDataToYaml(yamlFilesPath, data);
	}


	/**
	 * Method to get Data from dynamic yaml file
	 * @param token
	 * @return
	 */
	public String getDynamicYamlData(String token){
		Reader doc=null;
		try {
			doc = new FileReader(yamlFilesPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return getMapValue(object, token);
	}

	/**
	 * Method to get list from dynamic yaml file
	 * @param token
	 * @return
	 */
	public ArrayList<String> getDynamicYamlList(String token) {
		String[] dataList = (getDynamicYamlData(token)).split(" ");
		ArrayList<String> list = new ArrayList<String>();
		for(String element : dataList){
			list.add(element);
		}
		return list;
	}

	public Map<String,String> getMapFromString(String value)
	{
		value = value.substring(1, value.length()-1);          
		String[] keyValuePairs = value.split(",");             
		Map<String,String> map = new HashMap<>();               
		for(String pair : keyValuePairs)                       
		{
			String[] entry = pair.split("=");                  
			map.put(entry[0].trim(), entry[1].trim());         
		}

		return map;
	}
}
