package com.share2people.automation.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import com.share2people.qe.automation.framework.mobile.touchaction.drivers.Share2PeopleAndroidDriver;
import com.share2people.utils.PropFileHandler;

/**
 * 
 * @author nimit.jain
 *
 */
public class ConfigurationRegistory {

	Map<String, Object> registry;
	private static String OS = System.getProperty("os.name").toLowerCase();

	@SuppressWarnings("unchecked")
	public ConfigurationRegistory() {
		registry = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configurationRegistry.yaml"));
	}

	public WebDriver getDriver(Map<String, Object> config) throws MalformedURLException {
		Map<String, Object> options = new HashMap<String, Object>();
		return getDriver(config, options);
	}

	public WebDriver getDriver(Map<String, Object> config, Map<String, Object> options) throws MalformedURLException {
		String projectPath = System.getProperty("user.dir");
		String driverPath = null;
		String apkPath = null;
		int systemPort = 8201;
		
		
		
		
//		System.out.println(OS);
//
//		if (isWindows()) {
//			System.out.println("This is Windows");
//			driverPath = projectPath + "" + "/src/main/resources/drivers/window/chromedriver.exe";
//		} else if (isMac()) {
//			System.out.println("This is Mac");
//			driverPath = projectPath + "" + "/src/main/resources/drivers/mac/chromedriver";
//		} else if (isUnix()) {
//			System.out.println("This is Unix or Linux");
//			driverPath = projectPath + "" + "/src/main/resources/drivers/linux/chromedriver";
//		} else {
//			System.out.println("Your OS is not supported!!");
//		}

		apkPath = projectPath + "" + "/src/main/resources/apk/HashMusicPlayer_Automation_07_02_20.apk";
		System.out.println("The driver path is " + driverPath);

		String testConfiguration = System.getProperty("test-config", config.get("test-configuration").toString());

		if (options.containsKey("TEST_CONFIGURATION")) {
			testConfiguration = options.get("TEST_CONFIGURATION").toString();
		}

		TestSession.logger.info("Launching Test Configuration: " + testConfiguration + " ...");
		System.out.println("Launching Test on Configuration: " + testConfiguration + " ...");

		Map<String, String> configRegistry = (Map<String, String>) registry.get(testConfiguration);

		WebDriver driver = null;
		System.out.println(configRegistry);
		
		//String portNumber = PropFileHandler.readProperty("port");
		
		//String udidNumber = PropFileHandler.readProperty("udid");
		
		switch (configRegistry.get("browser")) {
		case "app":
			if (configRegistry.get("mode").equalsIgnoreCase("remote")) {
				if (configRegistry.get("os").equalsIgnoreCase("android")) {
					DesiredCapabilities capabilities = new DesiredCapabilities();
					Object testApps = config.get("test_app");
					Object appConfig = ((Map<String, String>) testApps).get("android");
					String activity = ((Map<String, String>) appConfig).get("activity");
					String appName = ((Map<String, String>) appConfig).get("file");
					String appPackage = ((Map<String, String>) appConfig).get("package");
					String appPath = apkPath;
					
					capabilities.setCapability("app", appPath);
					capabilities.setCapability("appPackage", "com.hashmusic.musicplayer"); 
					capabilities.setCapability("appActivity","com.hashmusic.musicplayer.activities.MainActivity");
					//capabilities.setCapability("androidPackage", appPackage);
					//capabilities.setCapability("appActivity", activity);
					capabilities.setCapability("newCommandTimeout", 100000);
					capabilities.setCapability("udid", configRegistry.get("deviceId"));
					capabilities.setCapability("unicodeKeyboard", true);
					capabilities.setCapability("–session-override",true);
					capabilities.setCapability("systemPort",systemPort);
					
					if (options.containsKey("APPIUM_APP_NO_RESET")) {
						capabilities.setCapability("noReset", options.get("APPIUM_APP_NO_RESET"));
					}
					
					if (options.containsKey("APPIUM_APP_FULL_RESET")) {
						capabilities.setCapability("fullReset", options.get("APPIUM_APP_NO_RESET"));
					}
					
					    //capabilities.setCapability("automationName", "UiAutomator2");
						
					
					capabilities.setCapability("deviceName", configRegistry.get("deviceName"));
					driver = new Share2PeopleAndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
					
				} 
			}
		}
		return driver;
	}
  
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

}
