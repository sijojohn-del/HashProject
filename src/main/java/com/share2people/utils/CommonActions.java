package com.share2people.utils;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.share2people.automation.framework.TestSession;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CommonActions {

	/**
	 * Method is used to swipe left the top header menu by one tab
	 * @param session
	 * @param element
	 */
	public static void swipeleft(TestSession session,WebElement element,int endx){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x, y, x-endx,y, 5000);
	}

	public static void swipeRight(TestSession session,WebElement element,int endx){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x, y, x+endx,y, 5000);
	}

	public static void longPress(TestSession session, WebElement element){
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		//action.longPress(element).release().perform();
	}
	
	

	public static void longPressOnAnyCoordinate(TestSession session, int x, int y){
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		//action.longPress(x, y, 3000).release().perform();
	}	

	public static void tapOnElement(TestSession session,WebElement ele){
		TouchAction tc = new TouchAction((MobileDriver) session.driver);
		//tc.tap(ele).perform();
	}

	public static void tapOnElementWithCoordinates(TestSession session,WebElement ele,int x, int y){
		TouchAction tc = new TouchAction((MobileDriver) session.driver);
		//tc.tap(ele, x, y).perform();
	}

	/**
	 * Method is used to scroll up the 3 dot menu options
	 * @param session
	 * @param element
	 */
	public static void scrollup(TestSession session,WebElement element,int endy){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x, y, x,y-endy, 2000);
	}

	public static void scrollDown(TestSession session,WebElement element,int endy){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X:"+ x+" Y: "+ y);
		//androiddriver.swipe(x, y+50, x,y+endy, 2000);
	}

	public static void slideUpTheFrequencySeekBarComman(TestSession session,WebElement element,int starty){
		@SuppressWarnings("rawtypes")
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X:"+ x+" Y: "+ y);
		//androiddriver.swipe(x, y+starty, x,y+5, 2000);

	}
	public static void slideUpTheFrequencySeekBar(TestSession session,WebElement element,int starty){
		@SuppressWarnings("rawtypes")
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X:"+ x+" Y: "+ y);
		//androiddriver.swipe(x+52, y+starty, x+52,y+10, 2000);
		//androiddriver.swipe(x+40, y+starty, x+40,y+10, 2000);
		//androiddriver.swipe(x, y+starty, x,y+10, 2000);


	}
	
	public static void slideDownTheFrequencySeekBar(TestSession session,WebElement element,int endy){
		@SuppressWarnings("rawtypes")
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X:"+ x+" Y: "+ y);
		//androiddriver.swipe(x+52, y+10, x+52,y+endy, 2000);
		//androiddriver.swipe(x+40, y+10, x+40,y+endy, 2000);
		//androiddriver.swipe(x, y+10, x,y+endy, 2000);
	}

	
	public static void tapOnScreen(TestSession session){
		TouchAction tc = new TouchAction((MobileDriver) session.driver);
		//tc.tap(100,100).perform();
	}

	public static void tapOnCoordinates(TestSession session,int x, int y){
		TouchAction tc = new TouchAction((MobileDriver) session.driver);
		//tc.tap(x,y).perform();
	}


	public static boolean isListSortedInAscendingOrder(List<String> list){
		boolean isSorted = true;
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.println("--------Comparing two string---------");
			System.out.println(list.get(i));
			System.out.println(list.get(i+1));
			if(list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) { 
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}

	public static boolean isListSortedInDescendingOrder(List<String> list){
		boolean isSorted = true;
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.println("--------Comparing two string---------");
			System.out.println(list.get(i));
			System.out.println(list.get(i+1));
			if(list.get(i).compareToIgnoreCase(list.get(i + 1)) < 0) { 
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}

	public static void swipeleftTheScreen(TestSession session,WebElement element){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x+700, y,x+20,y, 7000);
	}

	public static void swipeRightTheScreen(TestSession session,WebElement element){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x+20, y,x+700,y, 7000);
	}

	public static void gestureFromRightToLeft(TestSession session){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		//androiddriver.swipe(710, 500,10,500, 2000);
	}

	public static void gestureFromLeftToRight(TestSession session){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		//androiddriver.swipe(10, 500,710,500, 2000);
	}


	public static void scrollControllers(TestSession session, WebElement element){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		System.out.println("X axis: "+x);
		int y = element.getLocation().getY();
		System.out.println("Y axis: "+y);
		//androiddriver.swipe(x+10, y+50,x+140,y+50, 1000);
	}
	

	public static void swipeWidgetToRemove(TestSession session, WebElement element){
		AndroidDriver androiddriver = (AndroidDriver) session.driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//androiddriver.swipe(x+10, y+50,x+140,y+50, 2000);
	}
	
	
	
}