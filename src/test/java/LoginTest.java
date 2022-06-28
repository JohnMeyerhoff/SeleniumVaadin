import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

  private WebDriver driver;

  @BeforeEach
  void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

  }

  /**
   * Nach Aufgabenstellung: Für die User Story US1 (Login) sollte ein automatisierter Akzeptanztest
   * (...) entwickelt werden. der Logout wird nicht explizit getestet.
   */
  @Test
  public void test() {
    assertTrue(true);
    driver.get("http://localhost:8080/login");

    // find username by xpath
    driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-text-field/input")).sendKeys("AdvTest");
    // find password by xpath AND navigate to BUTTON
    driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-password-field/input"))
        .sendKeys("AdvTest", Keys.TAB, Keys.SPACE);


    driver.get("http://localhost:8080/login");

    // find username by xpath
    driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-text-field/input")).sendKeys("LauraStudent");
    // find password by xpath AND navigate to BUTTON
    driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-password-field/input"))
        .sendKeys("LauraStudent", Keys.TAB, Keys.SPACE);
    //assertEquals(driver.getCurrentUrl(), "http://localhost:8080/welcome", "Should be redirected to homepage.");
    new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/vaadin-app-layout/div/vaadin-vertical-layout/h2")));
    WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/vaadin-app-layout/div/vaadin-vertical-layout/h2"));
    assertEquals("Willkommen bei Academic Flow, LauraStudent", welcomeMessage.getText(), "Should be Welcome message'");
    // hier kann abmelden auch noch geklicked werden.


    

  }

  @AfterEach
  void tearDown() {

    driver.quit();
  }
}
