
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class estruturaTest {

    @Test
    public void testEstrutura() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/a/span"));
        actions.moveToElement(menu).perform();

        WebElement estrutura = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/div/a[3]"));
        estrutura.click();
        
        WebElement diretora = driver.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/p[2]/a"));
        assertTrue(diretora.getText().contains("Hermínia"));
    
        
        driver.quit();
    }

}
