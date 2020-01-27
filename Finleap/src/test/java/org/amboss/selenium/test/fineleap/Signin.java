package org.amboss.selenium.test.fineleap;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Signin {
    private FirefoxDriver driver;

    public Signin(FirefoxDriver driver) {
        this.driver = driver;
    }
    public void enter_userdetails(String username,String password)
    {
        driver.findElement(By.id("username")).sendKeys(username) ;
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("kc-submit")).click();
    }
    public void verify_validation()
    {
        String validationmessage = driver.findElement(By.className("notification-text")).getText();
        assertTrue(validationmessage.contains("Die Anmeldung ist fehlgeschlagen. Das Passwort und die E-Mail stimmen nicht überein. Bitte versuchen Sie es erneut."));
        System.out.println("User login fails as the user is not registered");
    }
    public void verify_login()
    {
        assertTrue(driver.getPageSource().contains("Willkommen bei Pylot"));
        System.out.println("User logged in successfully");
    }
}
