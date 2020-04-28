package com.hashmusic.stepdefinitions;

import java.io.IOException;

import com.share2people.helper.Helper;
import com.share2people.utils.PropFileHandler;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author nimit.jain
 *
 */
public class BaseSteps extends StepDefinitionInit {

	@Before
	public void setUp() throws Exception {
		
		System.out.println("STARTING TEST..... ");
		
		session = getTestSession();
		
		Thread.sleep(5000);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("I am in the tear function...");
		try {
			session.quit();
			System.out.println("Session is not terminated!!!");
		} finally {
			session = null;
		}
	}
	

}

