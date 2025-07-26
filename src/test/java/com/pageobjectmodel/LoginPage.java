package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.LoginPageInterfaceElements;
import com.utility.FileReaderManager;

public class LoginPage extends BaseClass implements LoginPageInterfaceElements{
	
	
	@FindBy(linkText = "login_xpath")
	private WebElement login;
	
	@FindBy(xpath = "usernam_xpath")
	private WebElement usernam;
	
	@FindBy(xpath = "passwd_xpath")
	private WebElement passwd;
	
	@FindBy(xpath = "loginbtn_xpath")
	private WebElement loginbtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void login() {
	
		try {
			FileReaderManager data = new FileReaderManager();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
//String login_xpath = "//a[@id='login_Layer']";
//	
//	String usernam_xpath = "//input[@type='text']";
//	
//	String passwd_xpath = "//input[@type='password']";
//	
//	String loginbtn_xpath = "//button[text()='Login']";        		
	

}
