package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStep {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify the success message after login {string}")
	public void userShouldVerifyTheSuccessMessageAfterLogin(String expLoginSuccessMsg) {
		String actLoginSuccessMsg = pom.getExplorePage().getLoginSuccessMsgText();
		Assert.assertEquals("verify login success message ", expLoginSuccessMsg, actLoginSuccessMsg);

	}

	@Then("User should verify the success message after search hotel {string}")
	public void userShouldVerifyTheSuccessMessageAfterSearchHotel(String expHotelSuccessMessage) {
		String actSelectHotelSuccessMsg = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
		Assert.assertEquals("verify hotel success message ", expHotelSuccessMessage, actSelectHotelSuccessMsg);


	}

	// tc3 selecthotel common steps

	@When("User select first hotel and save the hotel name,price")
	public void userSelectFirstHotelAndSaveTheHotelNamePrice() {
pom.getSelectHotelPage().selectHotel();
	}

	@When("User accept the alert for hotel booking")
	public void userAcceptTheAlertForHotelBooking() {
		pom.getSelectHotelPage().alertAccept();

	}

	@Then("User should verify the message after accepting alert {string}")
	public void userShouldVerifyTheMessageAfterAcceptingAlert(String string) {

	}
}
