package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//
public class RegistrationPage{
	private WebDriver driver;
//    private WebDriverWait wait;
    
    RegistrationPage(WebDriver driver){
    	this.driver=driver;
    }
    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
     By passwordField = By.id("password");
	 By firstName = By.id("first_name");
	 By lastName = By.id("last_name");
	 By address = By.id("address1");
	 By state = By.id("state");
	 By city = By.id("city");
	 By country = By.id("country");
	 By zipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
	 By mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
	 By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    
    //check if we are in the registration form page 
    public RegistrationPage checkThatRegistrationPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.findElement(pageTitle).getText(), "ENTER ACCOUNT INFORMATION");
        return this;
    }
	/////////////////////////////////////////////////////////////
    //Fill Registration Form
    public RegistrationPage fillRegistrationForm(String fName, String lName, String pass) {

   driver.findElement(firstName).sendKeys(fName);
   driver.findElement(lastName).sendKeys(lName);
   driver.findElement(passwordField).sendKeys(pass);
   driver.findElement(address).sendKeys("Alexandria");
    driver.findElement(state).sendKeys("Alex");
    driver.findElement(city).sendKeys("Alex");
   
    Select select = new Select(driver.findElement(country));
    select.selectByValue("Canada");
    
    driver.findElement(zipCode).sendKeys("21500");
    driver.findElement(mobileNumber).sendKeys("01234456978");
    System.out.print("Filling form Success");
    return this;
}
    public void submitAccount() {
        driver.findElement(createAccountButton).submit();
        System.out.print("button form Success");

//        return new RegistrationSuccessPage(driver);
 }
 

}
