package com.omrbranch.pages;

import org.junit.FixMethodOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.omrbranch.base.BaseClass;

public class MyBookingPage extends BaseClass {

	
	@FindBy(xpath="//a[@data-testid='username']")
	private WebElement myBookingPage;
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//div[@class='col-md-5']//h4")
	private WebElement bookingSuccessMsg;
	@FindBy(name="search")
	private WebElement txtSearchBox;
	@FindBy(xpath="//button[text()='Edit']")
	private WebElement btnEdit;
	@FindBy(name="check_in")
	private WebElement txtCheckInDate;
	@FindBy(xpath="//a[text()='31']")
	private WebElement checkIndate;
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement btnConfirm;
	@FindBy(xpath="//div[@class='alert mb-5 alert-success d-none']/ul//li//text()")
	private WebElement txtUpdatedSuccessMsg;
	@FindBy(xpath="(//div//a[text()='Cancel'])[1]")
	private WebElement btnCancel;
	@FindBy(xpath="//div[@class='alert mb-5 alert-success d-none']/ul//li//text()")
	private WebElement btnCancelSuccessMsg;
	@FindBy(xpath="//input[@name='search']")
	private WebElement txtSearch;
	
	
	
	
	
	


	
}
