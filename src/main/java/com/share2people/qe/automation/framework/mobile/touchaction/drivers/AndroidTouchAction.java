package com.share2people.qe.automation.framework.mobile.touchaction.drivers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

/**
 * 
 * @author nimit.jain
 *
 */
public class AndroidTouchAction extends TouchAction {

	public AndroidTouchAction(MobileDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*
	public TouchAction swipe (int startx, int starty, int endx, int endy, int duration)
	{
		return press(startx, starty).waitAction(duration).moveTo(endx, endy).release();
		
		
	}
	
	/**
	 * Method is used to tap on x and y location
	 * @param x
	 * @param y
	 * @param duration
	 * @return
	 
	public TouchAction tap(int x, int y, int duration)
	{
		return tap(x, y).release();
	}

	*/
}
