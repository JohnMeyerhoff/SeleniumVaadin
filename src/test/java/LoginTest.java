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
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginUsername\"]/input")).sendKeys("AdvTest");
    // find password by xpath AND navigate to BUTTON
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginPassword\"]/input"))
        .sendKeys("AdvTest", Keys.TAB, Keys.SPACE);
    WebElement error = driver.findElement(
        By.xpath("//*[@id=\"overlay\"]/flow-component-renderer/div"));
    assertEquals("User not found.", error.getText(), "Message should be 'User not found.'");

    driver.get("http://localhost:8080/login");

    // find username by xpath
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginUsername\"]/input")).sendKeys("LauraStudent");
    // find password by xpath AND navigate to BUTTON
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginPassword\"]/input"))
        .sendKeys("LauraStudent", Keys.TAB, Keys.SPACE);
    //assertEquals(driver.getCurrentUrl(), "http://localhost:8080/welcome", "Should be redirected to homepage.");

    WebElement abmelden = driver.findElement(By.partialLinkText("Abmelden"));
    assertEquals("Abmelden", abmelden.getText(), "Should be 'Abmelden'");
    // hier kann abmelden auch noch geklicked werden.

    new WebDriverWait(driver, 5000).until(
        ExpectedConditions.presenceOfElementLocated(By.id("shouldNotExist")));
    driver.get("http://localhost:8080/login");


  }

  @AfterEach
  void tearDown() {

    driver.quit();
  }
}
