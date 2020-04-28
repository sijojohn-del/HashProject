package com.hashmusic.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * 
 * @author nimit.jain
 *
 */
public class UpperMenuStepDefs extends StepDefinitionInit {
	
	 @When("^i get all the prerequisites$")
	    public void i_get_all_the_prerequisites() throws Throwable {

		 uppermenupo.getAllNeccessaryData();
	 
	 }
	
	@When("^I click on the allow button of HashMusic Player app$")
    public void i_click_on_the_allow_button_of_hashmusic_player_app() throws Throwable {

		uppermenupo.clickOnBottomMenuIcons();	
	
	}

	@And("^I am able to click on playlist screen$")
    public void i_am_able_to_click_on_playlist_screen() throws Throwable {

		uppermenupo.clickPlaylist();
		
	}
	
}
