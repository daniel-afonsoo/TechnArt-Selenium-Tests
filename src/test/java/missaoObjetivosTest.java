
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class missaoObjetivosTest {


    @Test
    public void testMissaoPage() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/a/span"));
        actions.moveToElement(menu).perform();

        WebElement missao = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/div/a[1]"));
        missao.click();

        WebElement en = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[1]/header/div/div/header/nav/ul/li/div/a[2]")));
        en.click();
        
        wait.until(ExpectedConditions.urlContains("mission.php"));
        driver.navigate().refresh();

        WebElement h3 = driver.findElement(By.xpath("//h3"));
       
        assertTrue(h3.getText().contains("MISSION"));
        driver.quit();
    }

}
