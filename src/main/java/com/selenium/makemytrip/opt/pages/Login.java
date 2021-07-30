package com.selenium.makemytrip.opt.pages;

import com.selenium.makemytrip.opt.base.BaseClass;
import com.selenium.makemytrip.opt.utility.ReadOtp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {
    @FindBy(xpath = "//ul[@class='userSection pushRight']/li[3]/div/p")
    WebElement login;
    @FindBy(xpath = "//*[@id='SW']/div[1]/div[1]/ul/li[3]/div[3]")
    WebElement popUpInfo;
    @FindBy(id = "username")
    WebElement emailOrMobileNumber;
    @FindBy(xpath = "//p[@class='makeFlex hrtlCenter flagCountryCode']")
    WebElement dropDownButton;
    @FindBy(xpath = "//input[@id='enterCountry']")
    WebElement countrySearchBar;
    @FindBy(xpath = "//div[@class='cntrycode__list']/div[1]")
    WebElement selectCountry;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//label[contains(text(),'Login with Phone/Email')]")
    WebElement loginPhone;
    @FindBy(id = "otp")
    WebElement otpTextBox;

    @FindBy(xpath = "//button[@class='capText font16']")
    WebElement loginButton;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication(String emailOrMobile, String countryName) throws InterruptedException {
        Thread.sleep(5000);
        login.click();
        Thread.sleep(400);
        enterEmailOrMobileNumber(emailOrMobile, countryName);

        continueButton.click();
        Thread.sleep(500);
        String otp;
        otp = ReadOtp.readOTP();
        otpTextBox.sendKeys(otp);
        Thread.sleep(400);
        loginButton.click();
        Thread.sleep(500);
    }

    private void enterEmailOrMobileNumber(String emailOrMobile, String countryName) {

        emailOrMobileNumber.sendKeys(emailOrMobile);

        dropDownButton.click();

        countrySearchBar.sendKeys(countryName);

        selectCountry.click();

    }

}
