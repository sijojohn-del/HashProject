$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Playlist.feature");
formatter.feature({
  "line": 1,
  "name": "To verify Playlist Functionalities",
  "description": "",
  "id": "to-verify-playlist-functionalities",
  "keyword": "Feature"
});
formatter.before({
  "duration": 29503350353,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I click on the Playlist option from the Upper bar",
  "keyword": "When "
});
formatter.match({
  "location": "PlaylistStepDefs.i_click_on_the_playlist_option_from_the_upper_bar()"
});
formatter.result({
  "duration": 604849057,
  "status": "passed"
});
formatter.scenario({
  "line": 70,
  "name": "[P_16]To verify user is able to create new playlist by entering the valid input",
  "description": "",
  "id": "to-verify-playlist-functionalities;[p-16]to-verify-user-is-able-to-create-new-playlist-by-entering-the-valid-input",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 69,
      "name": "@playlist1"
    }
  ]
});
formatter.step({
  "line": 71,
  "name": "I click on the New Playlist to Create new playlist",
  "keyword": "When "
});
formatter.step({
  "line": 72,
  "name": "I enter \"Test\" in the name field",
  "keyword": "When "
});
formatter.step({
  "line": 73,
  "name": "I click on the Create new button",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "I am able to successfully create the new playlist named \"Test\"",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaylistStepDefs.i_click_on_the_new_playlist_to_create_new_playlist()"
});
formatter.result({
  "duration": 1541339676,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 9
    }
  ],
  "location": "PlaylistStepDefs.i_enter_something_in_the_name_field(String)"
});
formatter.result({
  "duration": 935963157,
  "status": "passed"
});
formatter.match({
  "location": "PlaylistStepDefs.i_click_on_the_create_new_button()"
});
formatter.result({
  "duration": 510511686,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 57
    }
  ],
  "location": "PlaylistStepDefs.i_am_able_to_successfully_create_the_new_playlist_named_something(String)"
});
formatter.result({
  "duration": 10103138110,
  "status": "passed"
});
formatter.after({
  "duration": 3132343664,
  "status": "passed"
});
});