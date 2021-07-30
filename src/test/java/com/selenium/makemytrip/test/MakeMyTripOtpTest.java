package com.selenium.makemytrip.test;

import com.selenium.makemytrip.opt.base.BaseClass;
import com.selenium.makemytrip.opt.pages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTripOtpTest extends BaseClass {

    @Test
    public void login_to_application_with_otp() throws InterruptedException {

        Login login=new Login(driver);
        login.loginToApplication("9854002437","United States");
        String expectedUrl="https://www.makemytrip.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
