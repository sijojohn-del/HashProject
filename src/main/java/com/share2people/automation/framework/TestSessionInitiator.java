package com.share2people.automation.framework;

import static com.share2people.utils.ConfigFileReader.getTier;
import static com.share2people.utils.DataReadWrite.getProperty;

import java.util.HashMap;
import java.util.Map;

import com.share2people.utils.ConfigFileReader;
import com.share2people.utils.FileHandler;
import com.share2people.utils.YamlHandler;

public class TestSessionInitiator {
	public String appName; 
	public String baseUrl;
	public Boolean logToConsole;
	public FileHandler fileHandler;
	public YamlHandler apiRegistryYaml;
	public YamlHandler dbRegistoryYaml;
	public ConfigFileReader config;
	public TestSessionInitiator session;
	
	public TestSessionInitiator(String appName){
		this.appName = appName;
		
	    fileHandler = new FileHandler();
		config = new ConfigFileReader();
	}
	
	private String _getApiRegistryPath(String appName){
		
		try {
			String apiregistryPath = this.getClass().getClassLoader()
					.getResource("ApiRegistry/" + getTier().toUpperCase() + "/" + appName.toLowerCase() + ".yml")
					.getPath();
			return apiregistryPath;
		} catch (Exception e) {
			return null;
		}
	}

	private String _getDBRegistryPath(String appName){
		try {
		String dbRegistoryYaml = this.getClass().getClassLoader().getResource("DBRegistry/"+getTier().toUpperCase()+"/"+appName.toLowerCase()+".yml").getPath();
		return dbRegistoryYaml;
		} catch (Exception e) {
			return null;
		}
	}
	
	private static Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "timeout", "logtoconsole","database"};
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("Config.properties", string));
		}
		return config;
	}
	
	public static String getEnv() {
		String tier = System.getProperty("env");
		if (tier == null)
			tier = _getSessionConfig().get("tier");
		return tier;
	}

	public void stepStartMessage(String testStepName) {
		System.out.println(" ");
		System.out.println("***** STARTING TEST STEP:- " + testStepName.toUpperCase()+" *****"); 
		System.out.println(" ");
	}
}