package com.hashmusic.uppermenu.po;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.share2people.automation.framework.TestSession;
import com.share2people.helper.Helper;
import com.share2people.qe.automation.framework.pagefactory.MobileWebViewPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;

public class PlaylistPO extends MobileWebViewPage 
{

	public PlaylistPO(TestSession session) throws Exception 
	{
		super(session, "Applications/hash/Playlist");
	}

	public void clickOnPlaylistOption()
	{
		element("playlist").click();
	}

	public boolean checkIfPlaylistScreenOpen()
	{
		boolean isScreenOpen = false;
		List<WebElement> ele = elements("textNewPlayList");
		if(ele.size()==1)
			isScreenOpen = true;
		return isScreenOpen;
	}

	public boolean checkIfPlaylistIconHignlighted()
	{
		boolean isIconHighlighted = false;
		if(element("playlist").isSelected())
			isIconHighlighted = true;
		return isIconHighlighted;
	}

	public boolean check4PrecreatedPlaylistOnScreen() throws InterruptedException
	{
		boolean isPlaylistOnScreen = false;
		Helper.scrollDownMobile();

		//			WebElement eleNewPlaylist = element("textNewPlayList");
		//			int x1 = eleNewPlaylist.getLocation().getX();
		//			int y1 = eleNewPlaylist.getLocation().getY();
		//			System.out.println(">>>>>>>>>"+x1+">>>>>>>>"+y1);
		//			TouchAction ta = new TouchAction((MobileDriver) session.driver);
		//			ta.press(PointOption.point(x1,y1+400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
		//			 moveTo(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
		//			 release().perform();
		//			Thread.sleep(5000);

		List<WebElement> ele = elements("playlistTitles");
		if(ele.size()>4)
			isPlaylistOnScreen = true;
		return isPlaylistOnScreen;
	}

	public boolean checkIfPlaylistInSameOrder() throws InterruptedException
	{
		boolean isInSameOrder = false;
		Thread.sleep(5000);
		Helper.scrollDownMobiles();
		List<WebElement> ele = elements("playlistTitles");
		String[] elePlaylistOrder = {"Recently Added","Last Played","Most Played","Favourite"};
		List<String> elePlaylist = new ArrayList<String>();
		for(WebElement e: ele)
		{
			elePlaylist.add(e.getText());
		}
		System.out.println(">>>>>>"+elePlaylist);
		for(int i=0;i<4;i++)
		{
			if(elePlaylistOrder[i].equals(elePlaylist.get(i)))
				isInSameOrder = true;
			else
				isInSameOrder = false;
		}

		return isInSameOrder;
	}

	public boolean check3IconsOnToolbar()
	{
		boolean is3IconsVisible = false;
		List<WebElement> eleSearch = elements("iconSearch");
		List<WebElement> eleLeftDrawer = elements("iconLeftDrawer");
		List<WebElement> ele3Dots = elements("icon3Dots");
		if(eleSearch.size()==1&&eleLeftDrawer.size()==1&&ele3Dots.size()==1)
			is3IconsVisible = true;
		return is3IconsVisible;
	}

	public void clickOnIcon(String strIconName)
	{
		switch(strIconName)
		{
		case "Left Drawer":
			element("iconLeftDrawer").click();
			break;
		case "Search":
			element("iconSearch").click();
			break;
		case "3 Dots":
			element("icon3Dots").click();
			break;
		}
	}

	public boolean checkLeftDrawerMenuOpen()
	{
		boolean isLeftDrawerOpen = false;
		String strTopHeading = element("topHeadingLeftDrawer").getText();
		if(strTopHeading.equals("Playlist Arrangement"))
			isLeftDrawerOpen = true;
		return isLeftDrawerOpen;
	}

	public boolean checkSearchScreenOpen()
	{
		boolean isSearchScreenOpen = false;
		String strTopSearchText = element("topSearch").getText();
		if(strTopSearchText.equals("Search"))
			isSearchScreenOpen = true;
		return isSearchScreenOpen;
	}

	public boolean checkSearchScreenDividedInto4Category() throws InterruptedException
	{
		boolean isSearchScreenDivided = false;

		//		WebElement eleSearch = element("categoriesSearchScreen");
		//		int x1 = eleSearch.getLocation().getX();
		//		int y1 = eleSearch.getLocation().getY();
		//		TouchAction ta = new TouchAction((MobileDriver) session.driver);
		//		ta.press(PointOption.point(x1,y1+20)).moveTo(PointOption.point(x1,y1)).release().perform();

		String[] searchOrder = {"Songs","Artists","Albums","Folders"};

		List<WebElement> eleSearchOptions = elements("categoriesSearchScreen");
		for(int i = 0;i < eleSearchOptions.size();i++ )
		{
			System.out.println("*****"+eleSearchOptions.get(i).getText());
			if(searchOrder[i].equals(eleSearchOptions.get(i).getText()))
				isSearchScreenDivided = true;
			else
				isSearchScreenDivided = false;
		}
		return isSearchScreenDivided;
	}

	public void clickOnSearchBackIcon()
	{
		element("btnSearchBack").click();
	}

	public boolean check3DotIconClicked()
	{
		boolean isClicked = false;
		if(elements("txtPopUpMenu").size()==1)
			isClicked = true;
		return isClicked;
	}

	public boolean checkPopUpMenuText(String strText)
	{
		boolean isTextCorrect = false;
		String strPopUpMenuText = element("txtPopUpMenu").getText();
		if(strPopUpMenuText.equals(strText))
			isTextCorrect = true;
		return isTextCorrect;
	}

	public boolean checkNewPlaylistClicked()
	{
		boolean isClicked = false;
		if(elements("dialogBoxCreateNewPlaylist").size()==1)
			isClicked = true;

		return isClicked;
	}

	public void clickOnNewPlaylistButton()
	{
		element("textNewPlayList").click();
	}

	public boolean checkCreateNewPlaylistDialogBoxOpens()
	{
		boolean isDialogBoxOpen = false;
		if(element("dialogBoxCreateNewPlaylist").isEnabled())
			isDialogBoxOpen = true;
		return isDialogBoxOpen;
	}

	public void enterTextInNameField(String strText)
	{
		if(!strText.equals(""))
			element("editTxtPlaylistName").sendKeys(strText);
	}

	public void clickOnCreateNewButton()
	{
		element("btnCreateNew").click();
	}

	public boolean checkIfNewPlaylistCreated(String strPlaylistName) throws InterruptedException
	{
		boolean isPlaylistCreated = false;
		Helper.scrollDownMobile();
		List<WebElement> elePlaylistTitles = elements("playlistTitles");
		for(WebElement e : elePlaylistTitles)
		{
			System.out.println(">>>>>"+e.getText());
			if(e.getText().equals("Test"))
			{
				isPlaylistCreated = true;
				break;
			}
		}
		return isPlaylistCreated;
	}
	
	public void deletePlayListNamedTest() throws InterruptedException
	{
		//Helper.scrollDownMobile();
		List<WebElement> elePlaylistTitles = elements("playlistTitles");
		List<WebElement> ele3Dots = elements("playList3Dots");
		for(int i= 0; i< elePlaylistTitles.size();i++)
		{
			if(elePlaylistTitles.get(i).getText().equals("Test"))
			{
				System.out.println("!!!!Get Class>>>>>>"+elePlaylistTitles.get(i).getAttribute("class"));
			}
		}
	}

	public boolean checkIfErrorMsgDisplayed(String strErrorMsg)
	{
		boolean isErrorMsgDisplayed = false;
		String strError = element("editTxtPlaylistName").getAttribute("errorText");
		System.out.println("******"+strError);
		return isErrorMsgDisplayed;
	}

	public void editTagsOfSong()
	{

	}

	public void enterTextInSearchTextBox(String strSearch)
	{

	}

	public boolean checkIfSearchWorkOnAll4Category()
	{
		boolean isSearchWorks = false;
		return isSearchWorks;
	}
}
