package com.TestNG_rajeshscript;

import org.testng.annotations.Test;

public class TestNG_basic {
	
	


 

	// @Test - represents to a Test Case

	  // the @Test Annotations is implemented with the Method - when we test a functionality
	     //     of an application

	// The names of the User-Defined methods are called as Test Case Names

	// Whenever a Class contains multiple Test Cases - then the Test Cases are executed by
	//   the TestNG based on the Alphabetical Order of the Given Test Case Name


	// if the Test case name is starting with an Upper Case letter then - the fist Method
	//  which will be executed By the TestNG is starting with Upper Case again follwing the
	//   alphabetical order of the given Test Case Name

	//  if the Test Case need to be executed in a proper order then the Test cases should be
//	    set with Priority
 @Test
 
	 public void gmailApplicationLaunch()
	 {
	  System.out.println(" Gmail Application Launch Successfull ");
	 }
 }
