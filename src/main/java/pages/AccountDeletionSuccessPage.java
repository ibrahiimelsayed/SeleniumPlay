package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletionSuccessPage {

    public WebDriver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountDeletionSuccessPage(WebDriver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    public AccountDeletionSuccessPage checkThatAccountShouldBeDeletedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT DELETED!");
        return this;
    }

    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }
}