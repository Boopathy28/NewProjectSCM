package com.omrbranch.stepdefinition;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep {

	
	PageObjectManager pom = new PageObjectManager();

	

	@When("User dismiss the alert for cancel the selected hotel")
	public void userDismissTheAlertForCancelTheSelectedHotel() {
		pom.getSelectHotelPage().cancelAlert();

	}

	@Then("User should verify the message after cancel the alert {string}")
	public void userShouldVerifyTheMessageAfterCancelTheAlert(String string) {
		pom.getSelectHotelPage().getSelectHotelSuccessMsgText();

	}

	@When("User select price low to high option for filtering the hotel")
	public void userSelectPriceLowToHighOptionForFilteringTheHotel() {
		pom.getSelectHotelPage().hotelPriceLowToHigh();

	}

	@Then("User should verify all the price range displayed in low to high order formation")
	public void userShouldVerifyAllThePriceRangeDisplayedInLowToHighOrderFormation() throws InterruptedException {

		pom.getSelectHotelPage().beforePriceList();
		pom.getSelectHotelPage().getBtnPriceLowtoHigh();
		pom.getSelectHotelPage().afterPriceList();
		pom.getSelectHotelPage().verifyHotelPriceAscOrder();
	}

	@When("User select Name Descending option for filtering the hotel")
	public void userSelectNameDescendingOptionForFilteringTheHotel() {

	}

	@Then("User should verify all the hotel names displayed in descending order")
	public void userShouldVerifyAllTheHotelNamesDisplayedInDescendingOrder() {

	}

	@Then("User should verify all hotel names endswith selected roomtype {string}")
	public void userShouldVerifyAllHotelNamesEndswithSelectedRoomtype(String string) {

	}

	@Then("User should verify the success message after search {string}")
	public void userShouldVerifyTheSuccessMessageAfterSearch(String string) {

	}

}
