package com.share2people.qe.automation.framework.mobile.touchaction.drivers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

/**
 * 
 * @author nimit.jain
 *
 */
public class iOSTouchAction extends TouchAction {

	public iOSTouchAction(MobileDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*
	public TouchAction swipe (int startx, int starty, int endx, int endy, int duration)
	{
		int endX = endx-startx;
		int startX = endy-starty;
				
		return press(startX, starty).waitAction(duration).moveTo(endX, endy).release();
	}

	*/
}
