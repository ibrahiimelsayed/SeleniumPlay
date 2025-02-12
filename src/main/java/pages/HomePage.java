package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage{
	public final WebDriver driver;
	 By loginLink = By.xpath("//a[@href=\"/login\"]");
	    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
	    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
	    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
	    
	    public HomePage(WebDriver driver){
	    	this.driver=driver;
	    }
	    public HomePage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
	        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
	        return this;
	    }
	    public HomePage checkThatLogoutLinkShouldBeDisplayed() {
	        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
	        return this;
	    }
	    public LoginSignUpPage clickOnLoginLink(){
	        driver.findElement(loginLink).click();
	        return new LoginSignUpPage(driver);
	    }
	    public LoginSignUpPage clickOnLogoutLink(){
	        driver.findElement(logoutLink).click();
	        return new LoginSignUpPage(driver);
	    }
	    public AccountDeletionSuccessPage clickOnDeleteAccountLink(){
	        driver.findElement(deleteAccountLink).click();
	        return new AccountDeletionSuccessPage(driver);
	    }
	    
}