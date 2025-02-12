package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFactory{
	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
		 driver.manage().window().maximize();
	        return driver;
		
	}
}