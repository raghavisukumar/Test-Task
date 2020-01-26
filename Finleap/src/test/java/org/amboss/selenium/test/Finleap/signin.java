package org.amboss.selenium.test.Finleap;

import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class signin {

private static ResourceBundle rb = ResourceBundle.getBundle("userdetails");
private static signup signup;
	
	private static FirefoxDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.gecko.driver", rb.getString("webdriver.gecko.driver.path"));
		driver = new FirefoxDriver();
		driver.get(rb.getString("url"));
		signup = new signup();
		}
	
	/*@Test
	@Order(1)
	public void signup_verifysignin()
	{
		driver.findElement(By.id("signup")).click();
		signup.valid_userdetails();
		System.out.println("Valid user registered successfully");
		signin_validuser();

	}*/
	@Test
	@Order(1)
	public void signin_validuser()
	{
		driver.findElement(By.id("username")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("kc-submit")).click();
		assertTrue(driver.getPageSource().contains("Willkommen bei Pylot"));
		System.out.println("User logged in successfully");
		
	}
	/*@Test
	@Order(2)
	public void signin_unregistereduser()
	{
		driver.findElement(By.id("username")).sendKeys(rb.getString("unregistered.username"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("unregistered.password"));
		driver.findElement(By.id("kc-submit")).click();
		String validationmessage = driver.findElement(By.className("notification-text")).getText();
		System.out.println("the text is " + validationmessage);
		assertTrue(validationmessage.contains("Die Anmeldung ist fehlgeschlagen. Das Passwort und die E-Mail stimmen nicht überein. Bitte versuchen Sie es erneut."));
		System.out.println("User login fails as the user is not registered");
		
	}*/
	
	/*@AfterEach
	public void teardown()
	{
		driver.close();
	}*/
}
