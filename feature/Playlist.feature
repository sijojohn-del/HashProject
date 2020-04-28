Feature: To verify Playlist Functionalities

Background:
 When I click on the Playlist option from the Upper bar

@playlist
Scenario: [P_01] To verify user is able to click on Playlist option from the bottom menu
Then I verify playlist screen opens

@playlist
Scenario: [P_02]To verify when user enters the playlist screen at that time playlist icon from the bottom menu gets highlighted
Then I verify that the playlist icon gets highlighted

@playlist
Scenario: [P_03]To verify on Playlist screen user can see 4 pre-created playlist on the playlist screen
Then I verify that I see the 4 precreated playlist on the screen

@playlist
Scenario: [P_04]To verify the 4 pre-created playlist are of given name - Recently Added, Last Played, Most Played and Favourite
Then I verify that precreated list is in same order

@playlist
Scenario: [P_06]To verify search, left drawer and 3 dot icons are the 3 options
			 which are available on the toolbar of Playlist screen
Then I verify that I successfully see the 3 options on the toolbar of Playlist screen

@playlist
Scenario: [P_07]To verify when user click on the left icon from the playlist screen 
			 at that time left drawer menu should open
When I click on the left drawer icon from top menu
Then I verify that left drawer menu opens successfully

@playlist
Scenario: [P_08]To verify user is able to click on the search icon from the playlist screen
When I click on the search icon from top menu
Then I verify search screen opens successfully

@playlist
Scenario: [P_09]To verify search screen is divided into 4 category : Songs, Artists, Albums, Folders
When I click on the search icon from top menu
Then I scroll and verify that search screen is divided into 4 category

@playlist
Scenario: [P_10]To verify search will work on all 4 category from the playlist screen
When I click on the search icon from top menu
When I enter the "emulated" in the search text box
Then I verify that search will work on all 4 category

@playlist
Scenario: [P_11]To verify user is able to came back to the playlist screen from the search screen
When I click on the search icon from top menu 
When I click on the back icon
Then I verify that I came back to the Playlist screen

@playlist
Scenario: [P_12],[P_13]To verify user is able to click on the 3 dot icon from the toolbar of Playlist screen and
To verify user can see the 1 option from the top right popup menu i.e. Equalizer
When I click on the 3 dots icon from top menu
Then I verify that I am able to click on 3 dot icon
And I verify that a popup menu opens with text Equalizer

@playlist
Scenario: [P_14],[P_15]To verify user is able to click on the Create New Playlist option 
To verify when user click on the create new playlist option at that time dialog box opens
When I click on the New Playlist to Create new playlist
Then I verify that I can successfully click on the Create New Playlist
And I verify that Create New Playlist dialog box opens

@playlist1
Scenario: [P_16]To verify user is able to create new playlist by entering the valid input
When I click on the New Playlist to Create new playlist
When I enter "Test" in the name field 
When I click on the Create new button
Then I am able to successfully create the new playlist named "Test"

@playlist
Scenario: [P_17]To verify user is not able to create the playlist by entering the space in the playlist name
When I click on the New Playlist to Create new playlist
When I enter "  Test" in the name field 
When I click on the Create new button
Then I will get the error message "Enter Playlist name"

@playlist
Scenario: [P_18]To verify user is not able to create the playlist without entering the text in the name field
When I click on the New Playlist to Create new playlist
When I enter "" in the name field 
When I click on the Create new button
Then I will get the error message "Enter Playlist name"