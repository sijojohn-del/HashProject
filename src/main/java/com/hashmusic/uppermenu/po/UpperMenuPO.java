package com.hashmusic.uppermenu.po;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.share2people.automation.framework.TestSession;
import com.share2people.qe.automation.framework.pagefactory.MobileWebViewPage;
import com.share2people.utils.PropFileHandler;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class UpperMenuPO extends MobileWebViewPage {

	public UpperMenuPO(TestSession session) throws Exception 
	{
		super(session, "Applications/hash/UpperMenu");
	}

	public void clickOnBottomMenuIcons() throws InterruptedException 
	{
		Thread.sleep(1000);
		while(session.driver.findElements(MobileBy.xpath("//android.widget.Button[@text='ALLOW']")).size() > 0) 
		{	
			List<MobileElement> element = session.driver.findElements(MobileBy.xpath("//android.widget.Button[@text='ALLOW']"));
			element.get(0).click();
			break;
		}
		while(session.driver.findElements(MobileBy.xpath("//android.widget.Button[@text='Allow']")).size() > 0) 
		{					
			List<MobileElement> element = session.driver.findElements(MobileBy.xpath("//android.widget.Button[@text='Allow']"));		
			element.get(0).click();
			break;
		}	
	}

	public void clickPlaylist() throws InterruptedException 
	{
		element("playlist").click();
		Thread.sleep(10000);
	}

	public void getAllNeccessaryData() 
	{
		PropFileHandler.writeToFile("udid","");
		System.out.println("***********"+System.getProperty("udid"));	
		String udidValue = System.getProperty("udid");
		PropFileHandler.writeToFile("udid",udidValue);
		PropFileHandler.writeToFile("port","");
		System.out.println("***********"+System.getProperty("port"));
		String portValue = System.getProperty("port");
		PropFileHandler.writeToFile("port",portValue);
	}

}
