package org.amboss.selenium.test.fineleap;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Userlogintest {

    private static ResourceBundle rb = ResourceBundle.getBundle("userdetails");

    public FirefoxDriver driver;
    private static Signup signup;
    private static Signin signin;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.gecko.driver", rb.getString("webdriver.gecko.driver.path"));
        driver = new FirefoxDriver();
        driver.get(rb.getString("url"));
        signup = new Signup(driver);
        signin = new Signin(driver);
    }
    @Test
    @Order(1)
    public void verify_valid_userdetails() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"),true);
        signup.submit_verifySignin();
    }
    @Test
    @Order(2)
    public void verify_emptyvorname() {
        signup.enter_userdetails("",rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"),true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(3)
    public void verify_invalidvorname() {
        signup.enter_userdetails(rb.getString("invalid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"), true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(4)
    public void verify_emptynachname() {
        signup.enter_userdetails(rb.getString("valid.vorname"),"",rb.getString("valid.email"),rb.getString("valid.password"),true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(5)
    public void verify_invalidnachname() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("invalid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"),true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(6)
    public void verify_emptyemail() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),"",rb.getString("valid.password"),true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(7)
    public void verify_invalidemail() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("invalid.email"),rb.getString("valid.password"),true);
        signup.verify_submitdisabled();
    }

    @Test
    @Order(8)
    public void verify_registeredemail() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"),true);
        signup.verify_validation();
    }

    @Test
    @Order(9)
    public void verify_emptypassword() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),"",true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(10)
    public void verify_invalidpassword() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("invalid.password"),true);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(11)
    public void submitDisabled_WhenConsetIsNotChecked() {
        signup.enter_userdetails(rb.getString("valid.vorname"),rb.getString("valid.nachname"),rb.getString("valid.email"),rb.getString("valid.password"),false);
        signup.verify_submitdisabled();
    }
    @Test
    @Order(12)
    public void verify_SuccessSignin()
    {
        signin.enter_userdetails(rb.getString("valid.email"),rb.getString("valid.password"));
        signin.verify_login();
    }
    @Test
    @Order(13)
    public void verify_validation()
    {
        signin.enter_userdetails(rb.getString("unregistered.username"),rb.getString("unregistered.password"));
        signin.verify_validation();
    }

    @AfterEach
    public void teardown(){
        driver.close();
    }
}
