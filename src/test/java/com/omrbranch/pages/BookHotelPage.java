package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {

	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement bookHotelSuccessMsgTxt;
	@FindBy(id="own")
	private WebElement btnMyself;
	@FindBy(id="user_title")
	private WebElement sltSalutation;
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="user_phone")
	private WebElement txtPhoneNumber;
	
	@FindBy(id="user_email")
	private WebElement txtEmailAddress;
	
	@FindBy(id="gst")
	private WebElement rdoBtngst;
	
	@FindBy(id="gst_registration")
	private WebElement txtGstRegistrationNo;
	
	@FindBy(id="company_name")
	private WebElement txtCompanyName;
	
	@FindBy(id="company_address")
	private WebElement CompanyAddress;
	
	@FindBy(id="step1next")
	private WebElement btnFirstNext;

	@FindBy(id="high")
	private WebElement rdoBtnHigh;
	
	@FindBy(id="other_request")
	private WebElement txtOtherReq;
	
	@FindBy(id="step2next")
	private WebElement btnSecondNext;
	
	@FindBy(xpath="//h5[text()='Credit/Debit/ATM Card']")
	private WebElement paymentOption;
	
	@FindBy(id="payment_type")
	private WebElement sltPaymentType;
	
	@FindBy(id="card_type")
	private WebElement sltCardType;
	
	@FindBy(id="card_no")
	private WebElement txtCardNo;
	
	@FindBy(id="card_name")
	private WebElement txtCardName;
	
	@FindBy(xpath="//option[text()='November']")
	private WebElement txtCardMonth;
	
	@FindBy(xpath="//option[text()='2026']")
	private WebElement txtCardYear;
	
	@FindBy(id="cvv")
	private WebElement txtCardCvv;
	
	@FindBy(id="submitBtn")
	private WebElement btnSubmit;
	
	@FindBy(id="invalid-payment_type")
	private WebElement paymentTypeErrorMsg;
	
	@FindBy(id="invalid-card_type")
	private WebElement cardTypeErrorMsg;
	
	@FindBy(id="invalid-card_no")
	private WebElement cardNumberErrorMsg;
	
	@FindBy(id="invalid-card_name")
	private WebElement cardNameErrorMsg;
	
	@FindBy(id="invalid-card_month")
	private WebElement cardMonthErrorMsg;
	
	@FindBy(id="invalid-cvv")
	private WebElement cardCvvErrormsg;

	

	
	

}
