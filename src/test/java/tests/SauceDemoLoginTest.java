package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLoginTest {

    @Test
    public void loginTest() {

    	ChromeOptions options = new ChromeOptions();

    	options.addArguments("--headless=new");
    	options.addArguments("--disable-gpu");
    	options.addArguments("--window-size=1920,1080");

    	WebDriverManager.chromedriver().setup();

    	WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("inventory"),
                "Login Failed!"
        );

        System.out.println("Login Successful!");

        driver.quit();
    }
}