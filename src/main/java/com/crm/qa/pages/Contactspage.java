package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Contactspage extends TestBase {
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	//@FindBy(xpath="//select[@name='title']")
	//WebElement titlename;
	
	@FindBy(id = "first_name" )
	WebElement firstname;
	
	@FindBy(id = "surname" )
	WebElement lastname;
	
	
	@FindBy(name = "client_lookup" )
	WebElement Company;
	
	@FindBy(xpath ="(//input[@value='Save'])[1]")
	WebElement savebtn;
	
	public Contactspage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLable() {
		return contactsLabel.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String firstName,String lastName,String company) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		Company.sendKeys(company);
		savebtn.click();
		}
	

}
