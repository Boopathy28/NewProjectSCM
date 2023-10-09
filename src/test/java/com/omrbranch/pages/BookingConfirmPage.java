package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='seccess-box text-center']//h2//strong")
	private WebElement bookingIdSuccessMsgText;
	@FindBy(xpath = "//div[@class='seccess-box text-center']//p//strong")
	private WebElement hotelName;
	@FindBy(xpath="(//div[@class='seccess-box text-center']//h2//text())[2]")
	private WebElement bookingConfirmMsg;
	public WebElement getBookingIdSuccessMsgText() {
		return bookingIdSuccessMsgText;
	}
	public WebElement getHotelName() {
		return hotelName;
	}
	public WebElement getBookingConfirmMsg() {
		return bookingConfirmMsg;
	}

}
