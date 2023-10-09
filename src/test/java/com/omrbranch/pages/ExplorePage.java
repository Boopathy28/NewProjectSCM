package com.omrbranch.pages;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class ExplorePage extends BaseClass {

	public ExplorePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	private WebElement txtLoginSuccessMsg;
	@FindBy(id = "state")
	private WebElement sltState;
	@FindBy(id = "select2-city-container")
	private WebElement cityName;
	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement txtCityName;
	@FindBy(xpath = "//textarea[@placeholder='Select Room Type']")
	private WebElement txtRoomType;
	@FindBy(name = "check_in")
	private WebElement txtCheckIn;
	@FindBy(xpath = "//a[text()='30']")
	private WebElement cInDate;

	@FindBy(name = "check_out")
	private WebElement txtCheckOut;

	@FindBy(xpath = "//a[text()='31']")
	private WebElement cOutDate;

	@FindBy(id = "no_rooms")
	private WebElement numberOfRooms;
	@FindBy(id = "no_adults")
	private WebElement numberOfAdults;
	@FindBy(id = "no_child")
	private WebElement numberOfChilds;
	@FindBy(id = "no_child")
	private WebElement tabOfChilds;

	public WebElement getTabOfChilds() {
		return tabOfChilds;
	}

	@FindBy(xpath = "//iframe[@class='iframe']")
	private WebElement switchFrames;
	@FindBy(id = "searchBtn")
	private WebElement btnSearch;
	@FindBy(xpath = "//div[text()='Please select state']")
	private WebElement txtStateErrorMsg;
	@FindBy(id = "invalid-city")
	private WebElement txtCityErrorMsg;
	@FindBy(id = "invalid-check_in")
	private WebElement txtCheckInErrorMsg;
	@FindBy(id = "invalid-check_out")
	private WebElement txtCheckOutErrorMsg;
	@FindBy(id = "invalid-no_rooms")
	private WebElement txtRoomErrorMsg;
	@FindBy(id = "invalid-no_adults")
	private WebElement txtAdultErrorMsg;
	@FindBy(xpath = "//h3[text()='Hotel Booking']")
	private WebElement hotelBooking;

	public WebElement getHotelBooking() {
		return hotelBooking;
	}

	public WebElement getTxtLoginSuccessMsg() {
		return txtLoginSuccessMsg;
	}

	public WebElement getSltState() {
		return sltState;
	}

	public WebElement getCityName() {
		return cityName;
	}

	public WebElement getTxtCityName() {
		return txtCityName;
	}

	public WebElement getTxtRoomType() {
		return txtRoomType;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getcInDate() {
		return cInDate;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getcOutDate() {
		return cOutDate;
	}

	public WebElement getNumberOfRooms() {
		return numberOfRooms;
	}

	public WebElement getNumberOfAdults() {
		return numberOfAdults;
	}

	public WebElement getNumberOfChilds() {
		return numberOfChilds;
	}

	public WebElement getSwitchFrames() {
		return switchFrames;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getTxtStateErrorMsg() {
		return txtStateErrorMsg;
	}

	public WebElement getTxtCityErrorMsg() {
		return txtCityErrorMsg;
	}

	public WebElement getTxtCheckInErrorMsg() {
		return txtCheckInErrorMsg;
	}

	public WebElement getTxtCheckOutErrorMsg() {
		return txtCheckOutErrorMsg;
	}

	public WebElement getTxtRoomErrorMsg() {
		return txtRoomErrorMsg;
	}

	public WebElement getTxtAdultErrorMsg() {
		return txtAdultErrorMsg;
	}

	public void clickHotel() {
		elementClickJs(getHotelBooking());
	}

	public String getLoginSuccessMsgText() {
		String text = elementGetText(getTxtLoginSuccessMsg());
		return text;

	}

	public void exploreHotelPage(String stateName, String cityName, String roomType, String checkIn, String checkOut,
			String rooms, String adults, String child) throws AWTException, InterruptedException {

		elementClick(getSltState());
		selectOptionByText(getSltState(), stateName);
		Thread.sleep(10);

		elementClickJs(getCityName());
		sendkeysJs(getTxtCityName(), cityName);
		elementClick(getTxtRoomType());
		sendkeysAndEnter(getTxtRoomType(), roomType);
		sendkeysJs(getTxtCheckIn(), checkIn);
		sendkeysJs(getTxtCheckOut(), checkOut);

		elementClick(getNumberOfRooms());
		selectOptionByText(getNumberOfRooms(), rooms);
		elementClick(getNumberOfAdults());
		selectOptionByText(getNumberOfAdults(), adults);
		elementClick(getNumberOfChilds());
		elementSendkeys(getNumberOfChilds(), child);
		elementClickWithkyes(getTabOfChilds(), Keys.TAB, Keys.ENTER);
		// switchframeelement(getSwitchFrames());
		// tabKey();
		// elementClickJs(getBtnSearch());
		// enterKey();

	}

	public void exploreHotelPageWithMantodary(String stateName, String cityName, String checkIn, String checkOut,
			String rooms, String adults) throws AWTException {

		elementClick(getSltState());
		selectOptionByText(getSltState(), stateName);
		elementClick(getCityName());
		sendkeysAndEnter(getTxtCityName(), cityName);

		sendkeysJs(getTxtCheckIn(), checkIn);
		sendkeysJs(getTxtCheckOut(), checkOut);
		elementClick(getNumberOfRooms());
		selectOptionByText(getNumberOfRooms(), rooms);
		elementClick(getNumberOfAdults());
		selectOptionByText(getNumberOfAdults(), adults);
		// tabKey();
		//// switchframeelement(getSwitchFrames());
		//// elementClickJs(getBtnSearch());
		// enterKey();
		elementClickWithkyes(getTabOfChilds(), Keys.TAB, Keys.ENTER);
	}

	// without enter any field
	public void clickSearch() {
		switchframeelement(getSwitchFrames());
		elementClickJs(getBtnSearch());
	}

	// get all error message

	public String getStateErrorMsg() {
		String stateErrorMsg = elementGetText(getTxtStateErrorMsg());
		return stateErrorMsg;

	}

	public String getCityErrorMsg() {
		String cityErrorMsg = elementGetText(getTxtCityErrorMsg());
		return cityErrorMsg;

	}

	public String getCheckInErrorMsg() {
		String checkInErrorMsg = elementGetText(getTxtCheckInErrorMsg());
		return checkInErrorMsg;

	}

	public String getCheckOutErrorMsg() {
		String checkOutErrorMsg = elementGetText(getTxtCheckOutErrorMsg());
		return checkOutErrorMsg;

	}

	public String getRoomsErrorMsg() {
		String roomsErrorMsg = elementGetText(getTxtRoomErrorMsg());
		return roomsErrorMsg;
	}

	public String getAdultErrorMsg() {
		String adultErrorMSg = elementGetText(getTxtAdultErrorMsg());
		return adultErrorMSg;
	}
}
