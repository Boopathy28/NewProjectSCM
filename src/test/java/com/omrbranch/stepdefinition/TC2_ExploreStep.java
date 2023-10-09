package com.omrbranch.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_ExploreStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User enter the {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userEnterTheAnd(String stateName, String cityName, String roomType, String checkIn, String checkOut,
			String rooms, String adults, String child) throws AWTException, InterruptedException {
		pom.getExplorePage().clickHotel();
		pom.getExplorePage().exploreHotelPage(stateName, cityName, roomType, checkIn, checkOut, rooms, adults, child);
		pom.getExplorePage().clickSearch();
	}

	@When("User enter the {string},{string},{string},{string},{string} and {string}")
	public void userEnterTheAnd(String stateName, String cityName, String checkIn, String checkOut, String rooms,
			String adults) throws AWTException {
		pom.getExplorePage().clickHotel();
		pom.getExplorePage().exploreHotelPageWithMantodary(stateName, cityName, checkIn, checkOut, rooms, adults);
		pom.getExplorePage().clickSearch();

	}

	@When("User not enter the any details to perform search option")
	public void userNotEnterTheAnyDetailsToPerformSearchOption() throws InterruptedException {
		pom.getExplorePage().clickHotel();
		Thread.sleep(10);
		pom.getExplorePage().clickSearch();
		implicityWait(10);

	}

	@Then("User should verify the error message after search hotel {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyTheErrorMessageAfterSearchHotelAnd(String expStateErrorMsg, String expCityErrorMsg,
			String expCheckinErrorMsg, String expCheckOutErrorMsg, String expRoomsErrorMsg, String expAdultsErrorMsg)
			throws InterruptedException {
		Thread.sleep(5000);
		String actStateErrorMsg = pom.getExplorePage().getStateErrorMsg();
		System.out.println(actStateErrorMsg);
		Assert.assertEquals("verify State Error message", expStateErrorMsg, actStateErrorMsg);
		// boolean a = actStateErrorMsg.contains(expStateErrorMsg);
		// Assert.assertTrue(a);

		String actCityErrorMsg = pom.getExplorePage().getCityErrorMsg();
		Assert.assertEquals("verify City Error message", expCityErrorMsg, actCityErrorMsg);

		// boolean b = actCityErrorMsg.contains(expCityErrorMsg);
		// Assert.assertTrue(b);

		String actCheckInErrorMsg = pom.getExplorePage().getCheckInErrorMsg();
		Assert.assertEquals("verify CheckIn Error message", expCheckinErrorMsg, actCheckInErrorMsg);

		// boolean c = actCheckInErrorMsg.contains(expCheckinErrorMsg);
		// Assert.assertTrue(c);

		String actCheckOutErrorMsg = pom.getExplorePage().getCheckOutErrorMsg();
		Assert.assertEquals("verify CheckOut Error message", expCheckOutErrorMsg, actCheckOutErrorMsg);

		// boolean d = actCheckOutErrorMsg.contains(expCheckOutErrorMsg);
		// Assert.assertTrue(d);

		String actRoomsErrorMsg = pom.getExplorePage().getRoomsErrorMsg();
		Assert.assertEquals("verify Rooms Error message", expRoomsErrorMsg, actRoomsErrorMsg);

		// boolean e = actRoomsErrorMsg.contains(expRoomsErrorMsg);
		// Assert.assertTrue(e);

		String actAdultErrorMsg = pom.getExplorePage().getAdultErrorMsg();
		Assert.assertEquals("verify adult Error message", expAdultsErrorMsg, actAdultErrorMsg);

		// boolean f = actAdultErrorMsg.contains(expAdultsErrorMsg);
		// Assert.assertTrue(f);

	}

	@Then("User should verify the room type after search hotel {string}")
	public void userShouldVerifyTheRoomTypeAfterSearchHotel(String expRoomTypes) {

		String roomTypeHeaderMsg = pom.getSelectHotelPage().getRoomTypeHeaderMsg();
		Assert.assertEquals("verify Header Error message", expRoomTypes, roomTypeHeaderMsg);

		// boolean roomtype = roomTypeHeaderMsg.contains(expRoomTypes);
		// Assert.assertTrue(roomtype);

	}

}
