
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oportunidadesTest {


    @Test
    public void testOportunidades() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        
        driver.get("http://novotechneart.ipt.pt/tecnart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/a/span"));
        actions.moveToElement(menu).perform();

        WebElement oportunidades = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/ul/li[1]/div/a[5]"));
        oportunidades.click();
        
        WebElement bolsaInvestiga = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/a"));
        bolsaInvestiga.click();
        
        WebElement tituloBolsaInvestiga = driver.findElement(By.xpath("//h3"));
       
        assertTrue(tituloBolsaInvestiga.getText().contains("UIDP/05488/2020"));
        driver.quit();
    }

}
