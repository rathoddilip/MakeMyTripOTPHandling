package com.selenium.makemytrip.opt.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {

        //handle browser level show notification pop window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
    }

//    @AfterTest
//    public void closeBrowser() {
//
//        LogClass.info("******************************* End Test Cases ****************************************");
//        driver.quit();
//    }
}
