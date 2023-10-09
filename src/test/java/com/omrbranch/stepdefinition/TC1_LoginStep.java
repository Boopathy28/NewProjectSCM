package com.omrbranch.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMRBranch Hotel page")
	public void userIsOnTheOMRBranchHotelPage() {

	}

	@When("User login {string} and {string}")
	public void userLoginAnd(String userName, String password) {
		pom.getLoginPage().login(userName, password);

	}

	@Then("User should verify the error message after login {string}")
	public void userShouldVerifyTheErrorMessageAfterLogin(String expLoginErrorMsg) {
		String actLoginErrorMsgText = pom.getLoginPage().getLoginErrorMsgText();
		System.out.println(actLoginErrorMsgText);
		boolean errorMsg = actLoginErrorMsgText.contains(expLoginErrorMsg);
		Assert.assertTrue(errorMsg);

	}

	@When("User login using keyboard actions {string} and {string}")
	public void userLoginUsingKeyboardActionsAnd(String userName, String password) throws AWTException {

		pom.getLoginPage().loginEnterKey(userName, password);
	}

}