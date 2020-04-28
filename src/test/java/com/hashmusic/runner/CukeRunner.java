package com.hashmusic.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author nimit.jain
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		 plugin = { "progress", "html:target/cucumber-report.html", "json:target/cucumber-report.json",
		"html:target/cucumber-report.html", "junit:target/cucumber-report.xml" },
				 glue = {"com.hashmusic.stepdefinitions"}, monochrome= true,

		features = {"feature"}, tags = {"@playlist1"})
				 

public class CukeRunner {

}
				 


