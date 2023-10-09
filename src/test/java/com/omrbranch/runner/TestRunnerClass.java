package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@explore", plugin = {
		"json:target\\a.json" }, dryRun = false, snippets = SnippetType.CAMELCASE, features = "C:\\Users\\Hp\\eclipse-workspace\\OMRBranchHotelAutomation\\src\\test\\resources\\Features", glue = "com.omrbranch.stepdefinition")

public class TestRunnerClass {

	@AfterClass
	public static void afterClass() {
		// call the jvm Reports business logics
		Reporting.generateJvmReport("C:\\Users\\Hp\\eclipse-workspace\\OMRBranchHotelAutomation\\target\\a.json");

	}

}
