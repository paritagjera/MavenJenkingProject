package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	
	@FindBy(xpath = "(//td[@class='headertext'])[1]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath ="(//a[normalize-space()='New Contact'])[1]")
	WebElement newContactsLink;
	/*@FindBy(linkText = "New Contact")
	WebElement newContactsLink;*/
	
	@FindBy(xpath = "//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement taskLink;
	
	
	public HomePage() {
    	PageFactory.initElements(driver, this);
    }
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public Contactspage clickOnContactslink() {
		contactslink.click();
		return new Contactspage();
	}
	public DealsPage clickOnDealslink() {
		dealsLink.click();
		return new DealsPage();

	}
	
	public TasksPage clickOnTaskslink() {
		taskLink.click();
		return new TasksPage();

	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactsLink.click();
	}

}
