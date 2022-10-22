package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name = "username")
	WebElement username;
	
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signupbtn;
	
	@FindBy( xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
	
	public String validateLoginPageTitle() {
    	return driver.getTitle();
    }
    
    public boolean validateCrmImage() {
    	return crmlogo.isDisplayed();
    }
    
    public HomePage login(String un, String pwd) {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	
    	return new HomePage();
    }
    
	

}
