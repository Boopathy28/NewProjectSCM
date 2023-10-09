package com.omrbranch.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtEmail;

	@FindBy(id = "pass")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	@FindBy(id = "errorMessage")
	private WebElement txtLoginErrorMsg;
	

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtLoginErrorMsg() {
		return txtLoginErrorMsg;
	}

	public void login(String userName, String password) {
		elementSendkeys(getTxtEmail(), userName);
		elementSendkeys(getTxtPassword(), password);
		elementClick(getBtnLogin());

	}
	
	public void loginEnterKey(String userName, String password) throws AWTException {
		elementSendkeys(getTxtEmail(), userName);
		elementSendkeys(getTxtPassword(), password);
		enterKey();

	}
	
	public String getLoginErrorMsgText() {
		
		String elementGetText = elementGetText(getTxtLoginErrorMsg());
		return elementGetText;
		
	}

}
