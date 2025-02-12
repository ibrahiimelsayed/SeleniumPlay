package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginSignUpPage{
	public WebDriver driver;
	 By signupLoginLink=By.linkText("Signup / Login");
	 By emailField=By.xpath("//input[@data-qa=\"signup-email\"]");
	 By nameField=By.xpath("//input[@data-qa=\"signup-name\"]");
	 By loginmail=By.xpath("//input[@data-qa=\"login-email\"]");
	 By pass = By.xpath("//input[@data-qa=\"login-password\"]");
	 By signupbutton=By.xpath("//button[@data-qa=\"signup-button\"]");
	 By signinbutton=By.xpath("//button[@data-qa=\"login-button\"]");
	 By emailAlreadyExist = By.xpath("//p[text()='Email Address already exist!']");
     By signUpFormTitle = By.xpath("(//h2)[3]");

	 
     
	


	//constructor
	public LoginSignUpPage(WebDriver driver) {
		this.driver=driver;
		
	}
//	//go to sign up page from homepage 
//	public void goToSignupPage() {
//        driver.findElement(signupLoginLink).click();
//    }
	//check if we re in the loginsignup page 
	public LoginSignUpPage checkIfWeNavigatedToLoginPage() {
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
		Assert.assertEquals(driver.findElement(signUpFormTitle).getText(),"New User Signup!");
		return this;
		
	}
	//filling the signup form 
	
	public LoginSignUpPage fillSignUpName(String name) {
		driver.findElement(nameField).sendKeys(name);
		return this;

	}
	public LoginSignUpPage fillSignUpEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
		return this;

	}
	public RegistrationPage clickSignUpBtn() {
		driver.findElement(signupbutton).click();;
		return new RegistrationPage(driver);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	//filling the signup form 
	public LoginSignUpPage fillSignInPassword(String password) {
		driver.findElement(pass).sendKeys(password);
		return this;

	}
	public LoginSignUpPage fillSignInEmail(String loginemail) {
		driver.findElement(loginmail).sendKeys(loginemail);
		return this;

	}
	public HomePage clickSignInBtn() {
		driver.findElement(signinbutton).click();
     	return new HomePage(driver);
	}
}	

