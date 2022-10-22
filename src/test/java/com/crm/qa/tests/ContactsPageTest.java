/*author name:parita gajera*/

package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
		HomePage homepage;
		TestUtil testUtil;
		Contactspage contactsPage;
		
		String sheetName="contacts";
		
	
		
		public ContactsPageTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp() {
			initialization();
			testUtil=new TestUtil();
			contactsPage =new Contactspage();
			 loginPage = new LoginPage();
			 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			 testUtil.switchToFrame();
			//contactsPage=homepage.clickOnContactslink();
			
		}
		@Test(priority=1)
		public void verifyContactsPagelable() {
			Assert.assertTrue(contactsPage.verifyContactsLable());
		}
		//@Test(priority=2)
		public void selectSingleContactsTest() {
			contactsPage.selectContactsByName("AMIT POLARA");
		}
		
		//      	@Test(priority=3)
		public void selectMultipleContactsTest() {
			contactsPage.selectContactsByName("AMIT POLARA");
			contactsPage.selectContactsByName("ui hbcjsjsj");
		}
		
		
		@DataProvider
		public Object[][] getCRMTestData() {
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
			
		}
		
		@Test(priority=4, dataProvider="getCRMTestData")
			public void validateCreateNewContactsTest(String title,String firstName ,String lastName,String company) {
			homepage.clickOnNewContactLink();
			//contactsPage.createNewContact("Mr.","Tom", "Peter", "Google");
			contactsPage.createNewContact(title, firstName, lastName, company);
			}
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	
}
