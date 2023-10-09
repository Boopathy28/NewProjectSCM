package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runners.Parameterized.AfterParam;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public static String hotelName;
	public static String hotelPrice;
	static List<String> mi;

	static List<String> li;

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement selectHotelSuccessMsgText;
	@FindBy(id = "room_type")
	private WebElement roomtypeHeaderText;
	@FindBy(xpath = "//div[@id='hotellist']/div//h5[1]")
	private WebElement selectFirstHotelName;
	@FindBy(xpath = "//div[@id='hotellist']/div//h2[1]")
	private WebElement selectFirstHotelPrice;
	@FindBy(xpath = "(//div[@id='hotellist']/div//a)[1]")
	private WebElement selectfirstHotel;
	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement bookHotelSuccessMsgTxt;
	@FindBy(xpath = "//label[text()='Price low to high']")
	private WebElement btnPriceLowtoHigh;
	@FindBy(xpath = "//label[text()='Name Descending']")
	private WebElement btnNameDescending;
	@FindBy(xpath = "//div[@id='hotellist']/div//h5")
	private WebElement getAllHotelNames;
	@FindBy(xpath = "//div[@id='hotellist']/div//h2")
	private WebElement getAllHotelPrices;

	public WebElement getSelectHotelSuccessMsgText() {
		return selectHotelSuccessMsgText;
	}

	public WebElement getRoomtypeHeaderText() {
		return roomtypeHeaderText;
	}

	public WebElement getSelectFirstHotelName() {
		return selectFirstHotelName;
	}

	public WebElement getSelectFirstHotelPrice() {
		return selectFirstHotelPrice;
	}

	public WebElement getSelectfirstHotel() {
		return selectfirstHotel;
	}

	public WebElement getBookHotelSuccessMsgTxt() {
		return bookHotelSuccessMsgTxt;
	}

	public WebElement getBtnPriceLowtoHigh() {
		return btnPriceLowtoHigh;
	}

	public WebElement getBtnNameDescending() {
		return btnNameDescending;
	}

	public WebElement getGetAllHotelNames() {
		return getAllHotelNames;
	}

	public WebElement getGetAllHotelPrices() {
		return getAllHotelPrices;
	}

	public String getSelectHotelSuccessMsg() {

		String text = elementGetText(getSelectHotelSuccessMsgText());
		Assert.assertEquals("Verify Hotel", "Select Hotel", text);
		return text;

	}

	public String getRoomTypeHeaderMsg() {
		String roomHeader = elementGetText(getRoomtypeHeaderText());
		return roomHeader;

	}

	public String selectFirstHotelName() {

		hotelName = elementGetText(getSelectFirstHotelName());
		return hotelName;

	}

	public String selectFirstHotelprice() {

		hotelPrice = elementGetText(getSelectFirstHotelPrice());
		return hotelPrice;
	}

	public void selectHotel() {

		elementClickJs(getSelectfirstHotel());
	}

	public void alertAccept() {
		acceptAlert();
	}

	public void alertReject() {
		cancelAlert();
	}

	public void hotelPriceLowToHigh() {
		elementClickJs(getBtnPriceLowtoHigh());
	}

	public void beforePriceList() {
		List<WebElement> bfpriceRange = driver.findElements(By.xpath("//div[@id='hotellist']//strong"));
		int size = bfpriceRange.size();
		System.out.println(size);
		for (int i = 0; i < bfpriceRange.size(); i++) {
			String text2 = bfpriceRange.get(i).getText();

			mi = new ArrayList<String>();
			mi.add(text2);
			System.out.println(mi);

		}

	}

	public void afterPriceList() {
		List<WebElement> afpriceRange = driver.findElements(By.xpath("//div[@id='hotellist']//strong"));
		int size1 = afpriceRange.size();

		for (int i = 0; i < afpriceRange.size(); i++) {
			String text2 = afpriceRange.get(i).getText();
			li = new ArrayList<String>();
			li.add(text2);

		}

	}

	public void verifyHotelPriceAscOrder() throws InterruptedException {
		boolean b = li.equals(mi);
		Assert.assertFalse("verify", b);

	}

}
