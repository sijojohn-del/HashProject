package com.hashmusic.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlaylistStepDefs extends StepDefinitionInit 
{
    @When("^I click on the Playlist option from the Upper bar$")
    public void i_click_on_the_playlist_option_from_the_upper_bar() throws Throwable
    {
        playlistPO.clickOnPlaylistOption();
    }

    @Then("^I verify playlist screen opens$")
    public void i_verify_playlist_screen_opens() throws Throwable
    {
        Assert.assertTrue(playlistPO.checkIfPlaylistScreenOpen());
    }
    
    @Then("^I verify that the playlist icon gets highlighted$")
    public void i_verify_that_the_playlist_icon_gets_highlighted() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfPlaylistIconHignlighted());
    }
    
    @Then("^I verify that I see the 4 precreated playlist on the screen$")
    public void i_verify_that_i_see_the_4_precreated_playlist_on_the_screen() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.check4PrecreatedPlaylistOnScreen());
    }
    
    @Then("^I verify that precreated list is in same order$")
    public void i_verify_that_precreated_list_is_in_same_order() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfPlaylistInSameOrder());
    }

    @Then("^I verify that I successfully see the 3 options on the toolbar of Playlist screen$")
    public void i_verify_that_i_successfully_see_the_3_options_on_the_toolbar_of_playlist_screen() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.check3IconsOnToolbar());
    }
    
    @When("^I click on the left drawer icon from top menu$")
    public void i_click_on_the_left_drawer_icon_from_top_menu() throws Throwable
    {
        playlistPO.clickOnIcon("Left Drawer");
    }

    @Then("^I verify that left drawer menu opens successfully$")
    public void i_verify_that_left_drawer_menu_opens_successfully() throws Throwable
    {
    	Assert.assertTrue(playlistPO.checkLeftDrawerMenuOpen());
    }
    
    @When("^I click on the search icon from top menu$")
    public void i_click_on_the_search_icon_from_top_menu() throws Throwable 
    {
    	playlistPO.clickOnIcon("Search");
    }

    @Then("^I verify search screen opens successfully$")
    public void i_verify_search_screen_opens_successfully() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkSearchScreenOpen());
    }
    
 
    @Then("^I scroll and verify that search screen is divided into 4 category$")
    public void i_scroll_and_verify_that_search_screen_is_divided_into_4_category() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkSearchScreenDividedInto4Category());
    }
    
    @When("^I click on the back icon$")
    public void i_click_on_the_back_icon() throws Throwable
    {
        playlistPO.clickOnSearchBackIcon();
    }

    @Then("^I verify that I came back to the Playlist screen$")
    public void i_verify_that_i_came_back_to_the_playlist_screen() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfPlaylistScreenOpen());
    }

    @When("^I click on the 3 dots icon from top menu$")
    public void i_click_on_the_3_dots_icon_from_top_menu() throws Throwable 
    {
        playlistPO.clickOnIcon("3 Dots");
    }

    @Then("^I verify that I am able to click on 3 dot icon$")
    public void i_verify_that_i_am_able_to_click_on_3_dot_icon() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.check3DotIconClicked());
    }

    @And("^I verify that a popup menu opens with text Equalizer$")
    public void i_verify_that_a_popup_menu_opens_with_text_equalizer() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkPopUpMenuText("Equalizer"));
    }
    
    @When("^I click on the New Playlist to Create new playlist$")
    public void i_click_on_the_new_playlist_to_create_new_playlist() throws Throwable 
    {
    	playlistPO.clickOnNewPlaylistButton();
    }

    @Then("^I verify that I can successfully click on the Create New Playlist$")
    public void i_verify_that_i_can_successfully_click_on_the_create_new_playlist() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkNewPlaylistClicked());
    }

    @And("^I verify that Create New Playlist dialog box opens$")
    public void i_verify_that_create_new_playlist_dialog_box_opens() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkCreateNewPlaylistDialogBoxOpens());
    }
    
    @When("^I enter \"([^\"]*)\" in the name field$")
    public void i_enter_something_in_the_name_field(String strArg1) throws Throwable 
    {
        playlistPO.enterTextInNameField(strArg1);
    }

    @When("^I click on the Create new button$")
    public void i_click_on_the_create_new_button() throws Throwable 
    {
    	 playlistPO.clickOnCreateNewButton();
    }

    @Then("^I am able to successfully create the new playlist named \"([^\"]*)\"$")
    public void i_am_able_to_successfully_create_the_new_playlist_named_something(String strArg1) throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfNewPlaylistCreated(strArg1));
    	playlistPO.deletePlayListNamedTest();
    }
    
    @Then("^I will get the error message \"([^\"]*)\"$")
    public void i_will_get_the_error_message_something(String strArg1) throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfErrorMsgDisplayed(strArg1));
    }
    
    @When("^I enter the \"([^\"]*)\" in the search text box$")
    public void i_enter_the_something_in_the_search_text_box(String strArg1) throws Throwable 
    {
    	playlistPO.editTagsOfSong();
        playlistPO.enterTextInSearchTextBox(strArg1);
    }

    @Then("^I verify that search will work on all 4 category$")
    public void i_verify_that_search_will_work_on_all_4_category() throws Throwable 
    {
    	Assert.assertTrue(playlistPO.checkIfSearchWorkOnAll4Category());
    }

}
