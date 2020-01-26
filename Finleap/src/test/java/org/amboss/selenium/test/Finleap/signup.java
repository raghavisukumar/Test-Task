package org.amboss.selenium.test.Finleap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class signup {
	
	private static ResourceBundle rb = ResourceBundle.getBundle("userdetails");
	
	private FirefoxDriver driver;
	
	public signup(FirefoxDriver driver) {
        this.driver=driver;
    }
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.gecko.driver", rb.getString("webdriver.gecko.driver.path"));
		driver = new FirefoxDriver();
		driver.get(rb.getString("url"));
		driver.findElement(By.id("signup")).click();
		}
	
	@Test
	@Order(1)
	public void valid_userdetails()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		driver.findElement(By.id("kc-submit")).click();
	    System.out.println("Valid user registered successfully");
	    assertTrue(driver.getPageSource().contains("Willkommen bei Pylot"));
		System.out.println("User logged in successfully");

	}
	@Test
	@Order(2)
	public void empty_vorname()
	{
		
		
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		assertFalse((driver.findElement(By.id("kc-submit"))).isEnabled());
		System.out.println("Validation for Empty vorname is success");

	}
	@Test
	@Ignore
	@Order(3)
	public void invalid_vorname()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("invalid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		driver.findElement(By.id("kc-submit")).click();
	    System.out.println("Valid user registered successfully");

	}
	@Test
	@Order(4)
	public void empty_nachname()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		assertFalse((driver.findElement(By.id("kc-submit"))).isEnabled());
		System.out.println("Validation for Empty nachname is success");

	}
	@Test
	@Ignore
	@Order(5)
	public void invalid_nachname()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("invalid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		driver.findElement(By.id("kc-submit")).click();
	    System.out.println("Valid user registered successfully");

	}
	@Test
	@Order(6)
	public void empty_email()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		assertFalse((driver.findElement(By.id("kc-submit"))).isEnabled());
		System.out.println("Validation for Empty email is success");

	}
	@Test
	@Order(7)
	public void invalid_email()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("invalid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		driver.findElement(By.id("kc-submit")).click();
	    System.out.println("Valid user registered successfully");

	}
	@Test
	@Order(8)
	public void empty_password()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("formTermsConsent")).click();
		assertFalse((driver.findElement(By.id("kc-submit"))).isEnabled());
		System.out.println("Validation for Empty password is success");

	}
	@Test
	@Ignore
	@Order(9)
	public void invalid_password()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("invalid.password"));
		driver.findElement(By.id("formTermsConsent")).click();
		driver.findElement(By.id("kc-submit")).click();
	    System.out.println("Valid user registered successfully");

	}
	@Test
	@Order(10)
	public void empty_consent()
	{
		
		
		driver.findElement(By.id("firstName")).sendKeys(rb.getString("valid.vorname"));
		driver.findElement(By.id("lastName")).sendKeys(rb.getString("valid.nachname"));
		driver.findElement(By.id("email")).sendKeys(rb.getString("valid.email"));
		driver.findElement(By.id("password")).sendKeys(rb.getString("valid.password"));
		assertFalse((driver.findElement(By.id("kc-submit"))).isEnabled());
		System.out.println("Validation for unacknowledged consent is success");

	}
	@AfterEach
	public void teardown()
	{
		driver.close();
	}
	
}