package com.share2people.helper;

import com.galenframework.page.Page;
import com.hashmusic.stepdefinitions.StepDefinitionInit;
import com.share2people.automation.framework.TestSession;
import com.share2people.utils.PropFileHandler;
import com.share2people.utils.YamlHandler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.DataTable;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class Helper extends StepDefinitionInit{

	/**
	* Method is used to wait still page is loading. Wait for the second specified.
	*/
	public static void waitForPageLoaded() {
	ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	public Boolean apply(WebDriver driver) {
	return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	}
	};
	try {
	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(session.driver, 180);
	boolean result = wait.until(expectation);
	System.out.println(result+ " *******************Page is loaded completely***************");
	} catch (Throwable error) {
	org.junit.Assert.fail("Timeout waiting for 90 secondes to Page Load Request to complete.");
	}
	}

	public static void scrollDown()
	{
	((JavascriptExecutor) session.driver).executeScript("window.scroll(0,250)","");	
	}

	public static void scrollUp()
	{
	((JavascriptExecutor) session.driver).executeScript("window.scroll(0,-250)","");	
	}

	public static void threadWait(int waitsec) {
	threadWait(waitsec, null);
	}

	public static void threadWait(int waitsec, String message) {
	if (System.getProperty("implicitWait")!= null && Integer.parseInt(System.getProperty("implicitWait")) >= 0){
	waitsec = Integer.parseInt(System.getProperty("implicitWait"));
	}
	if (message != null) {
	System.out.println("\nWAITING " + waitsec + " seconds - " + message);
	} else {
	System.out.println("\nWAITING " + waitsec + " seconds for page synchronization!!!");
	}
	System.out.println(new String(new char[waitsec]).replace("\0", "="));
	for (int i = 0; i < waitsec; i++) {
	try {
	Thread.sleep(1000);
	System.out.print("=");
	} catch (InterruptedException ex) {
	}
	}
	System.out.println("");
	}


	public static HashMap<String, String> convertDataTableToMap(DataTable datatable) {
	HashMap<String, String> datamap = new HashMap<>();
	for (int i = 0; i < datatable.getGherkinRows().get(0).getCells().size(); i++) {
	datamap.put(datatable.getGherkinRows().get(0).getCells().get(i),
	datatable.getGherkinRows().get(1).getCells().get(i));
	}
	return datamap;
	}

	/**
	*
	* @param app xpro
	* @param usertype user
	* @return
	*/
	@SuppressWarnings("unchecked")
	public static Map<String, String> getRegisterDataFromYaml(String app, String usertype) {
	String registerYamlPath = "src/test/resources/testData/register-data.yml";

	YamlHandler yamlhandler = new YamlHandler(registerYamlPath);
	Map<String, String> registerMap = (Map<String, String>) yamlhandler.getYamlValues(app).get(usertype);

	return registerMap;
	}

	/**
	* Method is used to return the unique username
	* @return
	*/
	public static String uniqueUserName()
	{
	int number = uniqueNumber();
	String n = String.valueOf(number);
	String username = "nimit"+n+"Jain";
	return username;
	}

	/**
	* Method is used to return the unique Email Address
	* @return
	*/
	public static String uniqueEmailAddress()
	{
	int number = uniqueNumber();
	String n = String.valueOf(number);
	String email = "nimit"+n+"@malinator.com";
	return email;
	}
	
	public static String Playlist() 
	
	{
		int number = uniqueNumber();
		String n = String.valueOf(number);
		String playlist = "RockMusic" +n;
		return playlist;
	}

	/**
	* Method is used to generate a uniqueNumber upto 7 digit
	* @return
	*/
	public static int uniqueNumber()
	{
		Random rnd = new Random();
		int n = 1000000 + rnd.nextInt(9000000);
		return n;
	}

	public static int singleUnique() {
		
		Random rnd = new Random();
		
		int singlevalue = 1 + rnd.nextInt(9);
		
		return singlevalue;
	}
	
	
	public static void scrollDownMobile() throws InterruptedException{
		
		Thread.sleep(5000);
		
		AndroidDriver androidriver = (AndroidDriver) session.driver;
		
		Dimension dim = session.driver.manage().window().getSize();
		
		int height = dim.getHeight();
		
		int width = dim.getWidth();
		 
		int x = width/2;
		
		int top_y = (int)(height*0.80);
		
		int bottom_y = (int)(height*0.20);
		
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		
		//new TouchAction((MobileDriver) session.driver).press(x, top_y).waitAction(2000).moveTo(x,bottom_y).release().perform();
		
		new TouchAction((MobileDriver) session.driver).press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x,bottom_y)).release().perform();
		
		Thread.sleep(2000);	
	
	}
	

	public static void scrollDownMobiles() throws InterruptedException {
				
		Dimension dim = session.driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.40);
		int bottom_y = (int)(height*0.10);
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		new TouchAction((MobileDriver) session.driver).press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x,bottom_y)).release().perform();

	
	}
	
	public static void getAllNeccessaryData() {
		
		PropFileHandler.writeToFile("udid"," ");
		
		System.out.println("***********"+System.getProperty("udid"));
		
		String udidValue = System.getProperty("udid");
		
		PropFileHandler.writeToFile("udid",udidValue);
		
		PropFileHandler.writeToFile("port"," ");
		
		System.out.println("***********"+System.getProperty("port"));
		
		String portValue = System.getProperty("port");
		
		PropFileHandler.writeToFile("port",portValue);
		
		
	}
	
	
	
	public static void scrollUpMobile() throws InterruptedException {
		
		AndroidDriver androidriver = (AndroidDriver) session.driver;
		
		Dimension dim = session.driver.manage().window().getSize();
		
		int height = dim.getHeight();
		
		int width = dim.getWidth();
		 
		int x = width/2;
		
		int top_y = (int)(height*0.80);
		
		int bottom_y = (int)(height*0.20);
		
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		
		//new TouchAction((MobileDriver) session.driver).press(x, bottom_y).waitAction(2000).moveTo(x,top_y).release().perform();
		
		new TouchAction((MobileDriver) session.driver).press(PointOption.point(x, bottom_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(x,top_y)).release().perform();

		
		Thread.sleep(2000);
		
	
	}
	
	
	public static void closeKeyPad() 
	
	{
		
		AndroidDriver androidriver = (AndroidDriver) session.driver;

		androidriver.hideKeyboard();
	
	}
	
	
	public static String scrollUpToElement() throws InterruptedException 
	
	{
		String text = "";
	
		for(int i = 0; i < 10; i++) 
	
		{
		
		try 

		{
			
			MobileElement element = (MobileElement) session.driver.findElement(By.id("ivSearch"));
			
			Thread.sleep(2000);
			
			element.click();
			
			break;
			
		}catch(Exception e) 
		
		{
			
			scrollUpMobile();
		}
		
	  
		}
		
	return text;
	
	}
	
	public static void scrollUpToShuffle() throws InterruptedException 
	
	{
	
		for(int i = 0; i < 10; i++) 
	
		{
		
		try 

		{
			
			MobileElement element = (MobileElement) session.driver.findElement(By.id("llShufflePlay"));
			
			Thread.sleep(2000);
			
			element.click();
			
			break;
			
		}catch(Exception e) 
		
			{
			
			scrollUpMobile();
			}
		
	  }
		
	
	}
	
	public static String scrollUpToShuffles() throws InterruptedException 
	
	{
		String text = "";
	
		for(int i = 0; i < 10; i++) 
	
		{
		
		try 

		{
			
			MobileElement element = (MobileElement) session.driver.findElement(By.xpath("//android.widget.TextView[@text='Shuffle All']"));
			
			Thread.sleep(2000);
			
			text = element.getText();
			
			if(text.isEmpty()) 
			
			{
				
				System.out.println("Value not found");
				
				return text;
			}
			
		}catch(Exception e) 
		
			{
			
			scrollUpMobile();
			
			}
		
	  }
		
	return text;
	
	}
	
	
	public static String scrollDownToElement() throws InterruptedException 
	
	{
		String text = "";
		
	AndroidDriver androidriver = (AndroidDriver) session.driver;
	
	for(int i = 0; i < 1; i++) 
	
	  {
		
		try 
		
		{
			
			WebElement element = (WebElement) session.driver.findElements(By.id("com.musicplayer.playermusic:id/tvTile"));
			
			text = element.getText();
			
			if(text.isEmpty()) {
				
				System.out.println("Value not found");
				
				return text;
				
			}
			
		}catch(Exception e) 
		
		{
			
			scrollDownMobile();
		}
		
	  }
	
	return text;
	
	}
	
	
	public void sortPlaylist() {
		
		List<WebElement> elements = session.driver.findElements(By.id("flMove"));
		
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		
		//action.longPress(elements.get(0)).moveTo(elements.get(2)).release().perform();
		
		//action.longPress((LongPressOptions) elements.get(0)).moveTo((PointOption) elements.get(2)).release().perform();

		action.press(ElementOption.element(elements.get(0))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2))).moveTo(ElementOption.element(elements.get(2))).release().perform();
		
		
	}
	
	public static List<String> getAllThePlaylistsInViewPort() {
		
		List<String> playlistsinviewport = new ArrayList<String>();
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		for(WebElement el : playlists) {
			playlistsinviewport.add(el.getText());
			System.out.println(el.getText());
		}
		return playlistsinviewport;
	}
	
	public static List<String> getAllThePlaylistsInViewPorts() {
		
		List<String> playlistsinviewport = new ArrayList<String>();
		List<WebElement> playlists =  session.driver.findElements(By.id("song_title"));
		for(WebElement el : playlists) {
			playlistsinviewport.add(el.getText());
			System.out.println(el.getText());
		}
		return playlistsinviewport;
	}
	
	public static List<String> getAllThePlaylistsInPlaylistArrangementViewPorts() {
		
		List<String> playlistsinviewport = new ArrayList<String>();
		List<WebElement> playlists =  session.driver.findElements(By.id("tvPlaylistName"));
		for(WebElement el : playlists) {
			playlistsinviewport.add(el.getText());
			System.out.println(el.getText());
		}
		return playlistsinviewport;
	}
	
	public static List<String> getAllPlaylistsFromPlaylistArrangement() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInPlaylistArrangementViewPorts();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInPlaylistArrangementViewPorts();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		System.out.println(finallist);
		return finallist;
			
	}
	
	
	public static List<String> getAllPlaylists() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPort();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInViewPort();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		System.out.println(finallist);
		return finallist;
			
	}
	

	public static List<String> getAllThreeIconText() throws InterruptedException {
				
		List<String> finalList = new ArrayList<String>();
		List<String> currentList = new ArrayList<String>();
		List<String> listAfterScroll = new ArrayList<String>();
		
		
		do {
			
			currentList = getAllTextIconsValues();
			
			finalList.addAll(currentList);
			
			scrollDownMobile();
			
			listAfterScroll = getAllTextIconsValues();
			
			finalList.addAll(listAfterScroll);
			
		}while(!currentList.equals(listAfterScroll));
		
		return finalList;
		
	}
	
	public static List<String> getAllTextIconsValues(){
		
		List<String> allText = new ArrayList<String>();
		
		List<WebElement> allElement = session.driver.findElements(By.id("title"));
		
			for(WebElement allElements : allElement) {
				
				allText.add(allElements.getText());
				
			}
		
			return allText;
		
	}
	
	
	
	public static List<String> getAllSongs() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPorts();
			finallist.addAll(currentlist);
			scrollUpMobile();	
			listafterscrolling = getAllThePlaylistsInViewPorts();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		System.out.println(finallist);
		return finallist;
			
	}
	
	
	public static List<String> getAllSongsInAlbums() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPorts();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInViewPorts();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		return finallist;
			
	}
	
	public static List<String> getAllSongsArtist() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllTheArtistInViewPorts();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllTheArtistInViewPorts();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		return finallist;
			
	}
	
	public static List<String> getAllTheArtistInViewPorts() {
		
		List<String> playlistsinviewport = new ArrayList<String>();
		List<WebElement> playlists =  session.driver.findElements(By.id("song_artist"));
		for(WebElement el : playlists) {
			playlistsinviewport.add(el.getText());
			System.out.println(el.getText());
		}
		return playlistsinviewport;
	}
	
	
	public static void getAllSongs(String Playlist) throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPort();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInViewPort();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		System.out.println(finallist);
			
			if(finallist.contains(Playlist)) {
				
				System.out.println("The song is not deleted");
				
				Assert.assertTrue(false);
				
			} else {
				
				System.out.println("The song is deleted");
				
				Assert.assertTrue(true);
				
			}
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void checkSongs(List<String> allSongInGenres) throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPort();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInViewPort();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		System.out.println(finallist);
			
			if(finallist.contains(allSongInGenres)) {
				
				System.out.println("The song is not deleted");
				
				Assert.assertTrue(false);
				
			} else {
				
				System.out.println("The song is deleted");
				
				Assert.assertTrue(true);
				
			}			
		
	}
	
		
	public static void getAllPlaylistss(String Playlist) throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPort();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = getAllThePlaylistsInViewPort();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		System.out.println(finallist);
			
			if(finallist.contains(Playlist)) {
				
				System.out.println("The Playlist is not deleted");
				
				Assert.assertTrue(false);
				
			}else{
				
				System.out.println("The Playlist is deleted");
				
				Assert.assertTrue(true);
				
			}
		
		}
	
	public static void getAllRingtones(String Ringtone) throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = getAllThePlaylistsInViewPort();
			finallist.addAll(currentlist);
			scrollUpMobile();	
			listafterscrolling = getAllThePlaylistsInViewPort();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		
		System.out.println(finallist);
			
			if(finallist.contains(Ringtone)) {
				
				System.out.println("The Ringtone is not deleted");
				
				Assert.assertTrue(false);
				
			} else {
				
				System.out.println("The Ringtone is deleted");
				
				Assert.assertTrue(true);
				
			}
		
		}
	
	
	public static List<String> checkGetAllThePlaylistsInViewPorts() {
		
		List<String> playlistsinviewport = new ArrayList<String>();
		List<WebElement> playlists =  session.driver.findElements(By.id("song_title"));
		for(WebElement el : playlists) {
			playlistsinviewport.add(el.getText());
			System.out.println(el.getText());
		}
		return playlistsinviewport;
	}
	
	public static void checkDescAsceGetAllPlaylists() throws InterruptedException {
		
		List<String> finallist = new ArrayList<String>();
		List<String> currentlist = new ArrayList<String>();
		List<String> listafterscrolling = new ArrayList<String>();
		
		do {
			currentlist = checkGetAllThePlaylistsInViewPorts();
			finallist.addAll(currentlist);
			scrollDownMobile();	
			listafterscrolling = checkGetAllThePlaylistsInViewPorts();
			finallist.addAll(listafterscrolling);
		}while (!currentlist.equals(listafterscrolling));
		System.out.println(finallist); 
		

		if(finallist.get(0).startsWith("T") || finallist.get(0).startsWith("t") || finallist.get(0).startsWith("U") || finallist.get(0).startsWith("u") || finallist.get(0).startsWith("V") || 
				finallist.get(0).startsWith("v") || finallist.get(0).startsWith("W") || finallist.get(0).startsWith("w") || finallist.get(0).startsWith("x") || 
				finallist.get(0).startsWith("X") || finallist.get(0).startsWith("y") || finallist.get(0).startsWith("Y") ||  finallist.get(0).startsWith("z") || finallist.get(0).startsWith("Z")) {
			
			System.out.println("The list is sorted in descending order");
			
			Assert.assertTrue(true);
			
		}else {
			
			System.out.println("The list is sorted in ascending order");
			
			Assert.assertTrue(false);
			
		}
	}
	
	public static void clickOnPlaylist(String playlistname) throws InterruptedException {
		while(!clickOnPlaylistInViewPort(playlistname)) {
			
			Thread.sleep(3000);
			
			scrollDownMobiles();
		
			if(isListSame) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isListSame= false;
	
	static List<String> globalList = new ArrayList<String>();
	
	public static boolean clickOnPlaylistInViewPort(String playlistname) throws InterruptedException {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvPlayList"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			if(el.getText().equals(playlistname)) {
				
				el.click();
				
				flag = true;
				break;
			
			}
		}
		
		if(globalList.equals(CurrentList)) {
			
			isListSame = true;
			
		} else {
			
			isListSame = false;
			
			globalList.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalList.add(el.getText());
				
				
			}	
			
		}
		return flag;
	}
	
	public static void clickOnPlaylists(String playlistname) throws InterruptedException {
		while(!clickOnPlaylistInViewPorts(playlistname)) {
			
			Thread.sleep(3000);
			
			scrollDownMobiles();
		
			if(isListSameVal) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isListSameVal= false;
	
	static List<String> globalListsVal = new ArrayList<String>();
	
	public static boolean clickOnPlaylistInViewPorts(String playlistname) throws InterruptedException {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			if(el.getText().equals(playlistname)) {
				
				el.click();
				
				flag = true;
				break;
			
			}
		}
		
		if(globalListsVal.equals(CurrentList)) {
			
			isListSameVal = true;
			
		} else {
			
			isListSameVal = false;
			
			globalListsVal.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalListsVal.add(el.getText());
				
				
			}	
			
		}
		return flag;
	}
	
	
	
	public static void checkDefaultDisplayedViewPort(String View) throws InterruptedException {

		boolean flagPrimary = false;
		boolean flagSecondary1 = false;
		boolean flagSecondary2 = false;
		String primary = "Songs", secondary1 = "Artists", secondary2 = "Albums", secondary3 = "Folders";

		switch (View.toLowerCase()) {
		case "songs":
			primary = "Songs";
			secondary1 = "Artists";
			secondary2 = "Albums";
			secondary3 = "Folders";
			break;
		case "artists":
			primary = "Artists";
			secondary1 = "Songs";
			secondary2 = "Albums";
			secondary3 = "Folders";
			break;
		case "albums":
			primary = "Albums";
			secondary1 = "Songs";
			secondary2 = "Artists";
			secondary3 = "Folders";
			break;
		case "folders":
			primary = "Folders";
			secondary1 = "Songs";
			secondary2 = "Artists";
			secondary3 = "Albums";
			break;
		}

		for (int i = 0; i < 10; i++) {
			List<WebElement> firstElement = session.driver
					.findElements(By.xpath("//android.widget.TextView[@text='" + primary + "']"));
			List<WebElement> secondElement = session.driver
					.findElements(By.xpath("//android.widget.TextView[@text='" + secondary1 + "']"));
			List<WebElement> thirdElement = session.driver
					.findElements(By.xpath("//android.widget.TextView[@text='" + secondary2 + "']"));
			List<WebElement> fourthElement = session.driver
					.findElements(By.xpath("//android.widget.TextView[@text='" + secondary3 + "']"));

			if (!flagPrimary) {
				if (firstElement.size() > 0) {
					flagPrimary = true;
				} else {
					Assert.assertFalse(true);
				}

			} else {

				if (secondElement.size() > 0 || thirdElement.size() > 0 || fourthElement.size() > 0) {
					if (!flagSecondary1) {
						if (secondElement.size() > 0) {
							flagSecondary1 = true;
						} else {
							Assert.assertFalse(false);
						}
					} else {
						if (!flagSecondary2) {
							if (thirdElement.size() > 0) {
								flagSecondary2 = true;
							} else {
								if (secondElement.size() <= 0) {
									Assert.assertFalse(false);
								} else {
									scrollDownMobile();
								}
							}
						} else {
							if (fourthElement.size() > 0) {
								Assert.assertTrue(true);
								break;
							} else {
								if (secondElement.size() <= 0 && thirdElement.size() <= 0) {
									Assert.assertFalse(false);
								} else {
									scrollDownMobile();
								}
							}
						}
					}

				} else {
					scrollDownMobile();
				}
			}

		}
	}
	
	public static void checkSongsViewPort(String View) throws InterruptedException {
		
		boolean flag = false;
		
		for(int i = 0; i < 5; i++) {
			
			String quotes = '"' + View + '"';
			
			String xpathValue = "//android.widget.TextView[@text="+quotes+"]";
		
		List<WebElement> allCommon =  session.driver.findElements(By.xpath(xpathValue));
		
			if(allCommon.size() > 0) {
			
			  flag = true;
			  
			  break;
			
			} else {
				
				scrollDownMobile();
				
			}
		
		}
		
		if(flag == false) {
			
			Assert.assertFalse(false);
			
		}
		
		
		
	}
	
	public static void clickOnRingtones(String playlistname) throws InterruptedException {
		
		while(!clickOnRingtoneInViewPort(playlistname)) {
			
			scrollDownMobile();
		
			if(isListSameCheck) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isListSameCheck = false;
	
	static List<String> globalListCheck = new ArrayList<String>();
	
	public static boolean clickOnRingtoneInViewPort(String playlistname) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTitle"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			if(el.getText().equals(playlistname)) {
				
				el.click();
				
				flag = true;
				
				break;
			
			}
		}
		
		if(globalListCheck.equals(CurrentList)) {
			
			isListSameCheck = true;
			
		} else {
			
			isListSameCheck = false;
			
			globalListCheck.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalListCheck.add(el.getText());
				
				
			}	
			
		}
		
		return flag;
	}
	
	public static void clickOnCustomRingtones(String playlistname) throws InterruptedException {
		
		while(!clickOnCustomRingtoneInViewPort(playlistname)) {
			
			scrollDownMobile();
		
			if(isListSameChecks) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isListSameChecks = false;
	
	static List<String> globalListChecks = new ArrayList<String>();
	
	public static boolean clickOnCustomRingtoneInViewPort(String playlistname) throws InterruptedException {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		
		List<WebElement> threeIcon =  session.driver.findElements(By.id("ivMenu"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		int count = 0;
		
		for(int i = 0; i < playlists.size(); i++) { 
			
			count++;
			
			//System.out.println(playlists.get(count-1));
			
			CurrentList.add(playlists.get(i).getText());
			
			if(playlists.get(i).getText().equals(playlistname)) {
				
				Thread.sleep(3000);
				
				threeIcon.get(count-1).click();
					
				flag = true;
				
				break;
			
			}
		}
		
		if(globalListChecks.equals(CurrentList)) {
			
			isListSameChecks = true;
			
			} else {
			
			isListSameChecks = false;
			
			globalListChecks.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalListChecks.add(el.getText());
				
				
			}	
			
		}
		
		return flag;
	}
	
	
	public static void clickSpecficOnViewPort(String name) throws InterruptedException {
		
		while(!checkNamesInViewPort(name)) {
			
			Thread.sleep(3000);
			
			swipeLeft();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean checkNamesInViewPort(String name) {
		
		boolean flag = false;
		
		String quotes = '"' + name + '"';
		
		String xpathValue = "//android.widget.TextView[@text="+quotes+"]";
		
		List<WebElement> allListName = session.driver.findElements(By.xpath(xpathValue));
		
		for(WebElement el: allListName) {
			
			if(el.getText().equalsIgnoreCase(name)) {
				
				el.click();
				
				flag = true;
				
				break;
			}
			
		}
		
		return flag;
	}
	
	public static void clickSpecficOnViewPorts(String name) throws InterruptedException {
		
		while(!checkNamesInViewPort(name)) {
			
			Thread.sleep(3000);
			
			swipeRight();
		}
		
	}
	
	
	public static boolean checkNamesInViewPorts(String name) {
		
		boolean flag = false;
		
		String quotes = '"' + name + '"';
		
		String xpathValue = "//android.widget.TextView[@text="+quotes+"]";
		
		List<WebElement> allListName = session.driver.findElements(By.xpath(xpathValue));
		
		for(WebElement el: allListName) {
			
			if(el.getText().equalsIgnoreCase(name)) {
				
				el.click();
				
				flag = true;
				
				break;
			}
			
		}
		
		return flag;
	}
	
	
	
	
	public static void clickOnContacts(String playlistname) throws InterruptedException {
		while(!clickOnContactsInViewPort(playlistname)) {
			scrollDownMobile();
		
			if(isListSame) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isListSames= false;
	
	static List<String> globalLists = new ArrayList<String>();
	
	public static boolean clickOnContactsInViewPort(String playlistname) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvName"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			if(el.getText().equals(playlistname)) {
					
				el.click();
				
				flag = true;
				
				System.out.println("The contact is selected");
				
				break;
			
			}
		}
		
		if(globalLists.equals(CurrentList)) {
			
			isListSames = true;
			
			Assert.assertTrue(false);
			
		} else {
			
			isListSames = false;
			
			globalLists.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalLists.add(el.getText());
				
				
			}	
			
		}
		return flag;
	}
	
	
	
	public static void checkAddToQueue(String playlistname) throws InterruptedException {
		
		while(!AddToQueueViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean AddToQueueViewPort(String playlistname) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("song_title"));
		
		for(WebElement el : playlists) {
			
			if(el.getText().equals(playlistname)) {
				
				System.out.println("The Add to Queue is working fine");
				
				flag = true;
				
				break;
			}
		}
		return flag;
	}
	
	
	public static void checkAlbumName(String playlistname) throws InterruptedException {
		
		while(!CheckAlbumViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean CheckAlbumViewPort(String playlistname) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("song_title"));
		
		for(WebElement el : playlists) {
			
			if(el.getText().equals(playlistname)) {
				
				TouchAction action = new TouchAction((MobileDriver) session.driver);
				
				action.longPress(new LongPressOptions().withElement(ElementOption.element(el))).perform();
				
				flag = true;
				
				break;
			}
		}
		return flag;
	}
	
	
	public static void clickFavourite(String Favourite) throws InterruptedException {
		
		while(!checkFavourite(Favourite)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean checkFavourite(String Favourite) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		
		for(WebElement el : playlists) {
			
			if(el.getText().equals(Favourite)) {
				
				el.click();
				
				flag = true;
				
				break;
			}
		}
		return flag;
	}
	
	public static void clickAlbum(String playlistname) throws InterruptedException {
		
		while(!checkAlbumViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	static boolean isListSamess= false;
	
	static List<String> globalListss = new ArrayList<String>();
	
	public static boolean checkAlbumViewPort(String playlistname) {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvArtistName"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			System.out.println(CurrentList);
			
			if(el.getText().equals(playlistname)) {
				
				el.click();
				
				flag = true;
				
				Assert.assertTrue(true);
				
				break;
			}
		}
		
	if(globalListss.equals(CurrentList)) {
			
			isListSamess = true;
			
			Assert.assertTrue(false);
			
		} else {
			
			isListSamess = false;
			
			globalListss.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalListss.add(el.getText());
				
				
			}	
			
		}
		
		return flag;
	}
	
	
	public static void checkLongCustomPlaylists(String playlistname) throws InterruptedException {
		
		while(!checkLongCustomViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	static boolean isList= false;
	
	static List<String> global = new ArrayList<String>();
	
	public static boolean checkLongCustomViewPort(String playlistname) throws InterruptedException {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			CurrentList.add(el.getText());
			
			System.out.println(CurrentList);
			
			if(el.getText().equals(playlistname)) {
				
				TouchAction action = new TouchAction((MobileDriver) session.driver);
				
				action.longPress(new LongPressOptions().withElement(ElementOption.element(el))).perform();
				
				flag = true;
				
				//break;
			}
		}
		
	if(globalLists.equals(CurrentList)) {
			
			isListSames = true;
			
			scrollUpMobile();
			
			checkLongCustomPlaylists(playlistname);
			
			} else {
			
			isListSames = false;
			
			globalLists.clear();
			
		}
		
		
		if(!flag) {
			
			for(WebElement el : playlists) {
				
				globalLists.add(el.getText());
				
				
			}	
			
		}
		
		return flag;
	}
	
	
	public static boolean CheckPlaylistDisplayed(String playlistname) 
	
	{
		boolean flag = false;
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		for(WebElement el : playlists) 
		{
			if(el.getText().equals(playlistname)) 
			{
				flag = true;
				
				System.out.println("Value is found");
				
				break;
				
			}
		}
		return flag;
	}
	
	public static void LongPressPlaylist(String playlistname) throws InterruptedException {
		
		while(!LongPresslistInViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean LongPresslistInViewPort(String playlistname) {
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		for(WebElement el : playlists) {
			
			if(el.getText().equals(playlistname)) 
			
			{
				
				TouchAction action = new TouchAction((MobileDriver) session.driver);
				
				TouchActions actions = new TouchActions((MobileDriver) session.driver);
									
				//action.longPress(el).perform();
				
				//action.longPress((LongPressOptions) el).perform();

				action.longPress(new LongPressOptions().withElement(ElementOption.element(el))).perform();

				flag = true;
				
				break;
			}
		}
		return flag;
	}
	
	public static void LongPressAlbum(String playlistname) throws InterruptedException {
		
		while(!LongPressAlbumInViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean LongPressAlbumInViewPort(String playlistname) {
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("tvArtistName"));
		for(WebElement el : playlists) {
			
			if(el.getText().equals(playlistname)) 
			
			{
				
				TouchAction action = new TouchAction((MobileDriver) session.driver);
				
				//action.longPress(el).perform();
				
				//action.longPress((LongPressOptions) el).perform();

				action.longPress(new LongPressOptions().withElement(ElementOption.element(el))).perform();

				
				flag = true;
				
				break;
			}
		}
		return flag;
	}
	
	
	
	public static void renamePlaylist(String playlistname) throws InterruptedException {
		while(!renamePlaylistInViewPort(playlistname)) {
			scrollDownMobile();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean renamePlaylistInViewPort(String playlistname) {
		boolean flag = false;
		int count = 0;
		List<WebElement> playlists =  session.driver.findElements(By.id("tvTile"));
		List<WebElement> threeIcon =  session.driver.findElements(By.id("ivMenu"));
		for(WebElement el : playlists) {
			count++;
			if(el.getText().equals(playlistname)) {
			System.out.println(count - 1);
			threeIcon.get(count - 1).click();
			flag = true;
			break;
			}
		}
		return flag;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void clickCustomMadePlaylist() throws InterruptedException {
		
		List<MobileElement> allSelectedValues = session.driver.findElements(By.id("tvTile"));
		
		String allExistingPlaylistNames[] = {"Recently Added","Last Played","Most Played","Favourite"};
		
		try {
		
			for(int i =0; i < 10; i++) {
			
			if(allSelectedValues.get(i).getText().contains(allExistingPlaylistNames[i])) {
				
				System.out.println("Value found");
				
			} else {
				
				allSelectedValues.get(i).click();
				
				break;
				
			}
			
		}
			
		}catch(Exception e) {
			
			
			Helper.scrollDownMobiles();
		}
			
	}
		
		
		
	
	
	
	public static void swipeRight() {
		
		 	Dimension size = session.driver.manage().window().getSize();
		 
		    int anchor = (int) (size.height * 0.5);
		    
		    int startPoint = (int) (size.width * 0.9);
		    
		    int endPoint = (int) (size.width * 0.01);
		    
		    //new TouchAction((MobileDriver) session.driver).press(startPoint, anchor).waitAction(2000).moveTo(endPoint, anchor).release().perform();
		    
			new TouchAction((MobileDriver) session.driver).press(PointOption.point(startPoint, anchor)).moveTo(PointOption.point(endPoint,anchor)).release().perform();		
		
	}
	
	public static void swipeLeft() {
		
	 	Dimension size = session.driver.manage().window().getSize();
	 
	    int anchor = (int) (size.height * 0.5);
	    
	    int startPoint = (int) (size.width * 0.9);
	    
	    int endPoint = (int) (size.width * 0.1);
	    
	    //new TouchAction((MobileDriver) session.driver).press(endPoint, anchor).waitAction(2000).moveTo(startPoint, anchor).release().perform();
	    
		new TouchAction((MobileDriver) session.driver).press(PointOption.point(endPoint, anchor)).moveTo(PointOption.point(startPoint,anchor)).release().perform();

	
	}
	
	public static void forwardSeekBar() {
		
		WebElement element = session.driver.findElement(By.id("play_progress"));
		
		int start = element.getLocation().getX();
		
		int end = element.getSize().getWidth();
		
		int y = element.getLocation().getY();
		
		int moveTo = (int)(end * 0.8);
		
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		
		//action.press(start,y).moveTo(moveTo,y).release().perform();
		
		//action.press(PointOption.point(1280, 1013)).moveTo(PointOption.point(moveTo,y)).release().perform();

		action.press(ElementOption.point(start, y)).moveTo(ElementOption.point(moveTo,y)).release().perform();
		
	}
	
	public static void forwardBar() {
		
		WebElement element = session.driver.findElement(By.id("endmarkerCenter"));
		
		int start = element.getLocation().getX();
		
		int end = element.getSize().getWidth();
		
		int y = element.getLocation().getY();
		
		int moveTo = (int)(end * 0.8);
		
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		
		//action.press(start,y).moveTo(moveTo,y).release().perform();
		
		//action.press(PointOption.point(1280, 1013)).moveTo(PointOption.point(moveTo,y)).release().perform();

		action.press(ElementOption.element(element)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(ElementOption.point(300,300)).release().perform();
				
	}
	
	public static void backwardSeekBar() {
		
		WebElement element = session.driver.findElement(By.id("play_progress"));
		
		int start = element.getLocation().getX();
		
		int end = element.getSize().getWidth();
		
		int y = element.getLocation().getY();
		
		int moveTo = (int)(end * 0.2);
		
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		
		//action.press(moveTo,y).moveTo(start,y).release().perform();
		
		//action.press(ElementOption.point(moveTo, y)).moveTo(ElementOption.point(start,y)).release().perform();
		
		action.press(PointOption.point(moveTo,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(start,y)).release().perform();

		
	}
	
	public static void StartMarkerToRight() {
		
		WebElement element = session.driver.findElement(By.id("startmarkerCenter"));
		
		int start = element.getLocation().getX();
		
		int end = element.getSize().getWidth();
		
		int y = element.getLocation().getY();
		
		int moveTo = (int)(end * 0.8);
		
		TouchAction action = new TouchAction((MobileDriver) session.driver);
		
		//action.press(moveTo,y).moveTo(start,y).release().perform();

		action.press(PointOption.point(moveTo, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(start,y)).release().perform();

	}
	
	public boolean isToastLoaded(String txt) {
        //log(TAG + "isToastLoaded(): " + txt);
        List<MobileElement> elements = session.driver.findElements(By.xpath("//*[contains(@text,\"" + txt + "\")]"));
        return !elements.isEmpty();
    }
	
	public static void refreshApp() throws InterruptedException {
		
		AndroidDriver driver = (AndroidDriver) session.driver;
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

	}
	

	public static void checkAllSelectedSongs() throws InterruptedException {
		
		while(!checkOnAllSelectedSongs()) {
			
			scrollDownMobile();
		
			if(isCondition) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isCondition = false;
	
	static List<String> globalLis = new ArrayList<String>();
	
	public static boolean checkOnAllSelectedSongs() 
	
	{
		
		boolean flag = false;
		
		List<WebElement> checkBox =  session.driver.findElements(By.id("cbSong"));
		
		List<WebElement> song_title =  session.driver.findElements(By.id("song_title"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : checkBox) {
			
			String checked = el.getAttribute("checked");
			
			if(checked.equalsIgnoreCase("true")) {
				
				System.out.println("The songs checkboxes are checked");
				
			} else {
				
				System.out.println("The songs checkboxes are not checked");
				
				flag = false;
				
				Assert.assertTrue(false);
				
				break;
			}
				
		}
		
		for(WebElement song_name: song_title) {
			
			CurrentList.add(song_name.getText());
			
		}
		
		if(globalLis.equals(CurrentList)) {
			
			isCondition = true;
			
			flag = true;
			
		} else {
			
			isCondition = false;
			
			globalLis.clear();
			
		}	
		
		if(!flag) {
			
			for(WebElement el : song_title) {
				
				globalLis.add(el.getText());
							
			}	
			
		}
		
		return flag;
	}
	
	
public static void checkAllDeSelectedSongs() throws InterruptedException {
		
		while(!checkOnDeAllSelectedSongs()) {
			
			scrollUpMobile();
		
			if(isConditions) {
				
				break;
			
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isConditions = false;
	
	static List<String> globalLi = new ArrayList<String>();
	
	public static boolean checkOnDeAllSelectedSongs() {
		
		boolean flag = false;
		
		List<WebElement> playlists =  session.driver.findElements(By.id("cbSong"));
		
		List<WebElement> allSongs = session.driver.findElements(By.id("song_title"));
		
		List<String> CurrentList = new ArrayList<String>();
		
		for(WebElement el : playlists) {
			
			String checked = el.getAttribute("checked");
			
			if(checked.equalsIgnoreCase("true")) {
				
				System.out.println("The songs checkboxes are checked");
				
				Assert.assertTrue(false);
								
				break;
				
				} else {
				
				System.out.println("The songs checkboxes are not checked");
				
			}
			
			
		}
		
		for(WebElement songName: allSongs) {
			
			CurrentList.add(songName.getText());
			
		}
		
		
		if(globalLi.equals(CurrentList)) {
			
			isConditions = true;
			
			flag = true;
			
		} else {
			
			isConditions = false;
			
			globalLi.clear();
			
		}	
		
		if(!flag) {
			
			for(WebElement el : allSongs) {
				
				globalLi.add(el.getText());
							
			}	
			
		}
		
		return flag;
	}
	
	
	
}
   