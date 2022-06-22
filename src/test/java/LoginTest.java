import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

  @Test
  public void test() {
    assertTrue(true);
    driver.get("http://localhost:8080/login");

    // find username by xpath
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginUsername\"]/input")).sendKeys("AdvTest");
    // find password by xpath AND navigate to BUTTON
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginPassword\"]/input")).sendKeys("AdvTest", Keys.TAB, Keys.SPACE);
    String error = driver.findElement(By.xpath("//*[@id=\"overlay\"]/flow-component-renderer/div")).getText();
    assertEquals("User not found.", error);
    driver.findElement(By.xpath("//*[@id=\"vaadinLoginPassword\"]/input")).sendKeys("AdvTest", Keys.TAB, Keys.SPACE,Keys.ESCAPE);

    /*new WebDriverWait(driver, 5000).until(
        ExpectedConditions.presenceOfElementLocated(By.id("existiertbestimmtnicht")));
    driver.get("http://localhost:8080/login");
*/

  }

  @AfterEach
  void tearDown() {

    driver.quit();
  }
}
