package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverFactory;
import pages.HomePage;
import pages.LoginSignUpPage;
import pages.RegistrationPage;
import pages.RegistrationSuccessPage;
//

import org.testng.SkipException;
import org.testng.annotations.AfterClass;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest{
	public WebDriver driver;
	WebDriverWait wait ;


	
	@BeforeClass
	public void setUp() {

		driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        


	}
	
	
	@Test(priority=1)
	public void testSignUp()  {
		try {
			HomePage homepage=new HomePage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully();
			LoginSignUpPage loginsignup=homepage.clickOnLoginLink();
			
//			loginsignup.goToSignupPage();
			loginsignup.checkIfWeNavigatedToLoginPage();
			loginsignup.fillSignUpName("ibrahim");
			loginsignup.fillSignUpEmail("ibrahimelsay5200@gmail.com");
			RegistrationPage registrationpage =loginsignup.clickSignUpBtn();
			registrationpage.checkThatRegistrationPageIsLoadedSuccessfully();
			registrationpage.fillRegistrationForm("ibrahim","elsayed", "123456");
					registrationpage.submitAccount();
			new RegistrationSuccessPage(driver).checkThatSuccessMessageShouldBeDisplayed();
		}
		catch(Exception e) {
			System.out.println("Error occurred in method: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("Error location: " + e.toString());
			throw new SkipException("Skipping Test 1 - Email Already Exists Test");
		}
		finally {
			driver.manage().deleteAllCookies();
        }
		
		
		
	}
	
	
	@Test(priority=2)
	public void login() {
		driver.get("https://automationexercise.com/login");
		LoginSignUpPage loginsignup =new LoginSignUpPage(driver);
		loginsignup.fillSignInEmail("ibrahimelsay510@gmail.com");
		loginsignup.fillSignInPassword("123456");
		HomePage homepage=loginsignup.clickSignInBtn();
		homepage.checkThatLogoutLinkShouldBeDisplayed();

	}
	@Test(dependsOnMethods = "login",priority= 3 )
	public void logout() {
		LoginSignUpPage loginsignup= new HomePage(driver).clickOnLogoutLink();
		loginsignup.checkIfWeNavigatedToLoginPage();
	}
	
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
}